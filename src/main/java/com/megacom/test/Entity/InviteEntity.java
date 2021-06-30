package com.megacom.test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.megacom.test.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InviteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invite_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "sender_subs_id")
    private SubsEntity sender_subs;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "receiver_subs_id")
    private SubsEntity receiver_subs;

    @CreationTimestamp
    private LocalDateTime start_date;

    @Basic
    private LocalDateTime end_date = LocalDateTime.now().plusYears(300);

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

}
