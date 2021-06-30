package com.megacom.test.dao;

import com.megacom.test.Entity.InviteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepo extends JpaRepository<InviteEntity,Long> {
}
