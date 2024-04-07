package com.ngv.api.v1.controller;

import com.ngv.api.v1.dto.SavingDto;
import com.ngv.api.v1.service.SavingService;
import com.ngv.base.data.ResponseData;
import com.ngv.base.data.ResponseUtils;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SavingController {
    @Autowired
    public SavingService savingService;
    @GetMapping("/detail")
    @Operation(summary = "Chi tiết thông tin tiết kiệm")
    public ResponseEntity<ResponseData<SavingDto>> getSavingDetail(
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "identityNumber", required = false) String identityNumber){
        return ResponseUtils.success(savingService.getSaving(phoneNumber, identityNumber));
    }
}
