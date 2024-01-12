package com.vti.shopee.service.iml;

import com.vti.shopee.modal.dto.OderCreateRequestDto;
import com.vti.shopee.modal.entity.Oder;
import com.vti.shopee.modal.entity.Status;

import java.util.List;

public interface IOderService {
    Oder create(OderCreateRequestDto dto);

    Oder buyProduct(int oderId);

    Oder cancelOder(int oderId);

    List<Oder>  getAll();

    List<Oder> findAllByStatus(Status status , int accountId);
}
