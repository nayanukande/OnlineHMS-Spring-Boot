package com.nu.bill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nu.bill.entity.Bill;
import com.nu.bill.repository.BillRepository;
import com.nu.reservation.entity.Reservation;
import com.nu.reservation.repository.ReservationRepository;
import com.nu.room.feign.RoomFeignClient;
import com.nu.rate.feign.SetRatesFeignClient;
import com.nu.room.dto.RoomDTO;
import com.nu.rate.dto.SetRatesDTO;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomFeignClient roomFeignClient;  // Fetch Room Details

    @Autowired
    private SetRatesFeignClient setRatesFeignClient; // Fetch Special Rates

    @Override
    public Bill generateBill(Bill bill) {
        //Validate Input Data
        if (bill.getQuantity() <= 0 || bill.getPrice() <= 0) {
            throw new IllegalArgumentException("Quantity and Price must be greater than zero.");
        }

        if (billRepository.existsById(bill.getBillingNo())) {
            throw new IllegalArgumentException("Billing Number already exists.");
        }

        //Step 1: Fetch Reservation Details
        Reservation reservation = reservationRepository.findById(bill.getBillingNo())
            .orElseThrow(() -> new RuntimeException("Reservation not found"));

        //Step 2: Fetch Room Details
        RoomDTO room = roomFeignClient.getRoomById(reservation.getId())
            .orElseThrow(() -> new RuntimeException("Room not found in Manager Microservice"));

        //Step 3: Check for a Special Rate
        Optional<SetRatesDTO> specialRate = setRatesFeignClient.getSpecialRate(
            reservation.getCheckInDate(),
            reservation.getCheckOutDate(),
            reservation.getNumAdults() + reservation.getNumChildren(),
            room.getType()
        );

        double totalAmount;
        if (specialRate.isPresent()) {
            //Apply Special Rate
            SetRatesDTO rate = specialRate.get();
            totalAmount = rate.getFirstNightPrice() + (reservation.getNumNights() - 1) * rate.getExtensionPrice()+bill.getTaxes();
        } else {
            //No Special Rate: Use Default Room Price
            totalAmount = (room.getPrice() * reservation.getNumNights())+bill.getTaxes();
        }

        //Step 4: Store the Total Price and Save Bill
        bill.setTotalAmount(totalAmount);
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillByBillingNo(Long billingNo) {
        return billRepository.findById(billingNo)
            .orElseThrow(() -> new IllegalArgumentException("Bill not found with Billing No: " + billingNo));
    }
    
    @Override
    public void deleteBillByBillingNo(Long billingNo) {
    	billRepository.deleteById(billingNo);
    }
}
