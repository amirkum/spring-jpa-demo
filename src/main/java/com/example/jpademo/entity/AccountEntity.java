package com.example.jpademo.entity;

import javax.persistence.*;

@Entity(name = "Account")
@Table(name = "account")
public class AccountEntity extends DomainEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserEntity user;
    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    public AccountEntity() {
        super();
    }

    public AccountEntity(UserEntity user, String uuid) {
        this();
        this.user = user;
        this.uuid = uuid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
