package com.megacom.test.service;

import com.megacom.test.Entity.SubsEntity;
import com.megacom.test.dto.Subs;
import com.megacom.test.exception.PhoneExistException;
import com.megacom.test.exception.SubsNotFoundException;

import java.util.List;

public interface SubsService {

    SubsEntity registration(SubsEntity subsEntity) throws PhoneExistException;

    SubsEntity getById(Long id) throws SubsNotFoundException;

    List<SubsEntity> getActive(boolean active);

    Long delete(Long id);

}
