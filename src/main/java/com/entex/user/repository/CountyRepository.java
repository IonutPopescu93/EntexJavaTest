package com.entex.user.repository;

import com.entex.user.model.County;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountyRepository extends JpaRepository<County, Long> {

    County findByCountyCode(String countyCode);
}
