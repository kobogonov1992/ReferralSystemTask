package com.megacom.test.dao;

import com.megacom.test.Entity.SubsEntity;
import com.megacom.test.dto.Subs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubsRepo extends JpaRepository<SubsEntity,Long> {

    SubsEntity findByPhone(String phone);


    List<SubsEntity> findByActive(boolean active);

}
