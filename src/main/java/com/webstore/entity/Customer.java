package com.webstore.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.DiscriminatorType.STRING;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name="Typecli", discriminatorType=STRING, length=20)
@DiscriminatorValue("CUSTOMER")
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToMany
    List<Order> orders = new ArrayList<Order>();

    public void addOrder(Order order){
        orders.add(order);
    }
}
