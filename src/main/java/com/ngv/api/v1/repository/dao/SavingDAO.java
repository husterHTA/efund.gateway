package com.ngv.api.v1.repository.dao;

import com.ngv.api.v1.dto.SavingDetailDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class SavingDAO {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public List<SavingDetailDto> findSavingDetails(String phoneNumber, String identityNumber) {
        String sql = "{call sp_eF_ZaLo_TruyVanThongTinTietKiem(?, ?)}";

        return jdbcTemplate.query(
                sql,
                new Object[]{phoneNumber, identityNumber},
                new BeanPropertyRowMapper<>(SavingDetailDto.class)
        );
    }
}

