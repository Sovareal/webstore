package com.webstore.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("BLACKLISTED_CUSTOMER")
public class BlacklistedCustomer extends Customer{

    @Column(name = "blacklisted")
    private boolean blacklisted;
}
