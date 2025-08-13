package com.nu.rate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nu.rate.entity.SetRates;
import com.nu.rate.repository.SetRatesRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SetRatesServiceImpl implements SetRatesService {
    @Autowired
    private SetRatesRepository setRatesRepository;

    @Override
    public SetRates addSetRates(SetRates setRates) {
        return setRatesRepository.save(setRates);
    }

    @Override
    public List<SetRates> getAllSetRates() {
        return setRatesRepository.findAll();
    }

    @Override
    public Optional<SetRates> getSpecialRate(LocalDate checkInDate, LocalDate checkOutDate, int numGuests, String roomType) {
        return setRatesRepository.findByCheckInDateAndCheckOutDateAndNumGuestsAndRoomType(
            checkInDate, checkOutDate, numGuests, roomType);
    }
}
