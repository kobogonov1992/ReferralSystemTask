package com.megacom.test.service.impl;

import com.megacom.test.Entity.InviteEntity;
import com.megacom.test.Entity.SubsEntity;
import com.megacom.test.dao.InviteRepo;
import com.megacom.test.dao.SubsRepo;
import com.megacom.test.service.InviteEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InviteEntityServiceImpl implements InviteEntityService {

    private SubsRepo subsRepo;
    private InviteRepo inviteRepo;

    @Autowired
    public InviteEntityServiceImpl(SubsRepo subsRepo, InviteRepo inviteRepo) {
        this.subsRepo = subsRepo;
        this.inviteRepo = inviteRepo;
    }

    @Override
    public InviteEntity createInvite(InviteEntity inviteEntity, Long sender_id, Long receiver_id) {
        SubsEntity sender = subsRepo.getById(sender_id);
        SubsEntity receiver = subsRepo.getById(receiver_id);

        inviteEntity.setSender_subs(sender);
        inviteEntity.setReceiver_subs(receiver);

        return inviteRepo.save(inviteEntity);
    }

    @Override
    public InviteEntity updateInvite(Long id) {
        return null;
    }
}
