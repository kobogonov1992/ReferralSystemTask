package com.megacom.test.controller;

import com.megacom.test.Entity.InviteEntity;
import com.megacom.test.service.InviteEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invite")
public class InviteController {

    @Autowired
    private InviteEntityService inviteEntityService;

    @PostMapping
    public ResponseEntity createInvite(@RequestBody InviteEntity inviteEntity, @RequestParam Long sender_id, @RequestParam Long receiver_id ){
            return ResponseEntity.ok(inviteEntityService.createInvite(inviteEntity, sender_id, receiver_id));

    }

}
