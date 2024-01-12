package com.vti.shopee.repository;

import com.vti.shopee.modal.entity.Account;
import com.vti.shopee.modal.entity.Oder;
import com.vti.shopee.modal.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface OderRepository extends JpaRepository<Oder,Integer> {

    List<Oder> findAllByStatusAndAccount_Id(Status status ,int accountId);

    List<Oder> findAllByAccount_Id(int accountId);

//    //cach khac dung hql
//    @Query(value = "SELECT o FROM Oder o WHERE o.status =:status AND o.accont=:accountId")
//    List<Oder> findAllByStatusV2(@Param("status") Status status);
//
//    @Query(value = "SELECT * FROM Oder o WHERE o.status =:status",nativeQuery = true)
//    List<Oder> findAllByStatusV3(Status status);

}
