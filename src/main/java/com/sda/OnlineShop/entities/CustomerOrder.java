package com.sda.OnlineShop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class CustomerOrder {
    @Id
    @GeneratedValue
    private String orderId;
    @ManyToOne
    @JoinColumn
    private User user;
    @OneToMany(mappedBy = "customerOrder")
    private List<SelectedProduct> selectedProducts;
}
