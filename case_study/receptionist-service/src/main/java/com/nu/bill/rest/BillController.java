package com.nu.bill.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nu.bill.entity.Bill;
import com.nu.bill.service.BillService;
import java.util.List;

@RestController
@RequestMapping("/receptionist/bills")
public class BillController {
    
    @Autowired
    private BillService billService;

    @PostMapping("/generateBill")
    public Bill generateBill(@RequestBody Bill bill) {
        return billService.generateBill(bill);
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/{billingNo}")
    public Bill getBillByBillingNo(@PathVariable Long billingNo) {
        return billService.getBillByBillingNo(billingNo);
    }
    
    @DeleteMapping("/{billingNo}")
    public void deleteBill(@PathVariable Long billingNo) {
        billService.deleteBillByBillingNo(billingNo);
    }
}
