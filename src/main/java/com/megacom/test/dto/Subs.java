package com.megacom.test.dto;

import com.megacom.test.Entity.SubsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Subs {

    private Long id;
    private String phone;

    public static Subs toModel(SubsEntity entity){
        Subs model = new Subs();
        model.setId(entity.getSubs_id());
        model.setPhone(entity.getPhone());
        return model;
    }

}
