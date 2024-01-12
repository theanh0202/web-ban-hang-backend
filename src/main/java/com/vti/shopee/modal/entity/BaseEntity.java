package com.vti.shopee.modal.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass//DANH DAU CLASS NAY CUNG LA 1 PHAN TRONG CAC ENTITY KHAC

public class BaseEntity {
    @Column(name = "CREATE_DATE")
    protected Date createDate;

    @Column(name = "CREATE_by")
    protected String createBY;

    @Column(name = "UPDATE_DATE")
    protected Date updateDate;

    @Column(name = "UPDATE_BY")
    protected String updateBy;

    /**
     * ham nay duoc goi khi entity duoc them moi
     *
     */
    @PrePersist
    public void onPrePersist(){
        this.createDate=new Date();
        this.createBY="Mr.theanh create";
    }

    /**
     * ham nay duoc goi toi khi entity dc update
     */

    public void onPreUpDate(){
        this.updateDate=new Date();
        this.updateBy="Mr.theanh update";
    }
    /**
     * ham nay duoc goi toi khi update
     */

}
