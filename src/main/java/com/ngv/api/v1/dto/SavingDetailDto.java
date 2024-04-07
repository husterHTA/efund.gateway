package com.ngv.api.v1.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class SavingDetailDto {
    private String maKhachHang;
    private String tenKhachHang;
    private String soCmnd;
    private String ngaySinh;
    private String soSoTg;
    private String soDu;
}
