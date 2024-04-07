package com.ngv.api.v1.service;

import com.ngv.api.v1.dto.DepositDto;
import com.ngv.api.v1.dto.SavingDetailDto;
import com.ngv.api.v1.dto.SavingDto;
import com.ngv.api.v1.repository.dao.SavingDAO;
import com.ngv.base.data.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavingService extends BaseService {

    @Autowired
    private SavingDAO savingDAO;

    @Transactional
    public SavingDto getSaving(String phoneNumber, String identityNumber) {
        List<SavingDetailDto> savingDetailList = savingDAO.findSavingDetails(phoneNumber, identityNumber);
        SavingDto savingDto = new SavingDto();
        List<DepositDto> deposits = new ArrayList<>();
        if (savingDetailList == null || savingDetailList.isEmpty()) {
            return null;
        }
        for (SavingDetailDto detail : savingDetailList) {
            if (savingDetailList.indexOf(detail) == 0) {
                savingDto.setCustomerId(detail.getMaKhachHang());
                savingDto.setCustomerName(detail.getTenKhachHang());
                savingDto.setIdentityNumber(detail.getSoCmnd());
                savingDto.setBirthDay(detail.getNgaySinh());
            }

            DepositDto depositDto = new DepositDto();
            depositDto.setDepositNumber(detail.getSoSoTg());
            depositDto.setBalance(detail.getSoDu());
            deposits.add(depositDto);
        }

        savingDto.setDeposits(deposits);
        return savingDto;
    }
}
