package com.ngv.api.v1.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class DepositDto {
    private String depositNumber;
    private String balance;
}
