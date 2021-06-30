package com.megacom.test.controller;

import com.megacom.test.Entity.SubsEntity;
import com.megacom.test.exception.PhoneExistException;
import com.megacom.test.exception.SubsNotFoundException;
import com.megacom.test.service.SubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subs")
public class SubsController {

    @Autowired
    private SubsService subsService;

    @GetMapping("/")
    public ResponseEntity getSubs() {
        try {
            return ResponseEntity.ok("Выполнено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody SubsEntity subsEntity) {
        try {
            subsService.registration(subsEntity);
            return ResponseEntity.ok("Абонент сохранён");
        } catch (PhoneExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка регистрации");
        }
    }

    @GetMapping("/byId")
    public ResponseEntity getOneSub(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(subsService.getById(id));
        } catch (SubsNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка поиска");
        }
    }

    @GetMapping("/active")
    public ResponseEntity getActive (@RequestParam boolean active) {

          List<SubsEntity> subs =subsService.getActive(active);

          if(subs.isEmpty()){
              return new ResponseEntity(HttpStatus.NOT_FOUND);
          }
                return new ResponseEntity<>(subs,HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubById(@PathVariable Long id){
       return ResponseEntity.ok(subsService.delete(id));
    }
}
