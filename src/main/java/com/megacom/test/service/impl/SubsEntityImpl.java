package com.megacom.test.service.impl;

import com.megacom.test.Entity.SubsEntity;
import com.megacom.test.dao.SubsRepo;
import com.megacom.test.exception.PhoneExistException;
import com.megacom.test.exception.SubsNotFoundException;
import com.megacom.test.service.SubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsEntityImpl implements SubsService {

    @Autowired
    private SubsRepo subsRepo;

    @Override
    public SubsEntity registration(SubsEntity subsEntity) throws PhoneExistException {
        if(subsRepo.findByPhone(subsEntity.getPhone()) != null)
            throw  new PhoneExistException("Номер уже существует");
        return subsRepo.save(subsEntity);
    }

    @Override
    public SubsEntity getById(Long id) throws SubsNotFoundException {
        SubsEntity subsEntity = subsRepo.findById(id).get();
        if(subsEntity == null){
            throw new SubsNotFoundException("Абонент не найден");
        }
        return subsEntity;
    }

    @Override
    public List<SubsEntity> getActive(boolean active) {
//       SubsEntity subs = subsRepo.findByActive(active);
        return  subsRepo.findByActive(active);
    }

    @Override
    public Long delete(Long id) {
       subsRepo.deleteById(id);
       return id;
    }
}
