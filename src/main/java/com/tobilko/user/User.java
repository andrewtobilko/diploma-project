package com.tobilko.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "account")
@Entity(name = "account")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String login;
    private String password;

}
