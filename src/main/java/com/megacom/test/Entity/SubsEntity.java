package com.megacom.test.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Subscriber")
public class SubsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subs_id;

    private String phone;

    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender_subs")
    private List<InviteEntity> senderInvite = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiver_subs")
    private List<InviteEntity> receiverInvite =  new ArrayList<>();


    @UpdateTimestamp
    private LocalDateTime edit_date;

    @CreationTimestamp
    private LocalDateTime add_date;


}
