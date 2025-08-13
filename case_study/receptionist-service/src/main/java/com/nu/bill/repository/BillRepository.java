package com.nu.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.bill.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
