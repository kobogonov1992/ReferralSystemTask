package com.megacom.test.service;

import com.megacom.test.Entity.InviteEntity;

public interface InviteEntityService {

    InviteEntity createInvite( InviteEntity inviteEntity, Long senderId, Long receiverId );

    InviteEntity updateInvite(Long id);

}
