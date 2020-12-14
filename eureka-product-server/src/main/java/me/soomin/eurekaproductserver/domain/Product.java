package me.soomin.eurekaproductserver.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String productName;

    private String productDetail;

    @Column(columnDefinition = "bigint not null unique")
    private Long accountId;
}
