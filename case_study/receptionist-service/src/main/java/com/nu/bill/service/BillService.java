package com.nu.bill.service;

import com.nu.bill.entity.Bill;
import java.util.List;

public interface BillService {
    Bill generateBill(Bill bill);
    List<Bill> getAllBills();
    Bill getBillByBillingNo(Long billingNo);
    void deleteBillByBillingNo(Long billingNo);
    
}
