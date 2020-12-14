package me.soomin.client.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Account implements Serializable {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String email;

    @Transient
    private String password;

    private Long ProductId;
}
