package com.example.Onfire.entity;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdOrderDetail")
    private Long idOrderDetail;

    @Column(name = "IdOrder")
    private Long idOrder;

    @Column(name = "idProduct")
    private Long idProduct;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdProduct",insertable = false,updatable = false)
    public Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdOrder",insertable = false,updatable = false)
    public Order order;

    public OrderDetail(Long idOrderDetail, Long idOrder, Long idProduct, Integer quantity, Double price) {
        this.idOrderDetail = idOrderDetail;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
    }
}
