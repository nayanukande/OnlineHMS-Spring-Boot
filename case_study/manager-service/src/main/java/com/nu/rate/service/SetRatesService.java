package com.nu.rate.service;

import com.nu.rate.entity.SetRates;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SetRatesService {
    SetRates addSetRates(SetRates setRates);
    List<SetRates> getAllSetRates();
    Optional<SetRates> getSpecialRate(LocalDate checkInDate, LocalDate checkOutDate, int numGuests, String roomType);
}
