package com.vti.shopee.controller;

import com.vti.shopee.modal.dto.AccountCreateDto;
import com.vti.shopee.modal.dto.OderCreateRequestDto;
import com.vti.shopee.modal.entity.Account;
import com.vti.shopee.modal.entity.Oder;
import com.vti.shopee.modal.entity.Status;
import com.vti.shopee.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin("*")
@Validated

public class OderController {
    @Autowired
    private OderService oderService;

    @PostMapping("/create")
    public Oder create(@RequestBody @Valid OderCreateRequestDto dto){
        return oderService.create(dto);
    }

    @PostMapping("/buy/{id}")
    public Oder buyProduct(@PathVariable int id){
        return oderService.buyProduct(id);
    }

    @PostMapping("/cancel/{id}")
    public Oder cancelOder(@PathVariable int id){
        return oderService.cancelOder(id);
    }

    @GetMapping("/get-by-status")
    public List<Oder> findAllByStatus(@RequestParam(required = false) Status status , @RequestParam int accountId){
        return oderService.findAllByStatus(status,accountId);
    }



}
