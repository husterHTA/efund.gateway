package com.ngv.api.v1.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class SavingDto {
    private String customerId;
    private String customerName;
    private String identityNumber;
    private String birthDay;
    private List<DepositDto> deposits;
}
