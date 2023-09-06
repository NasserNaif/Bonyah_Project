package com.example.bonyah.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "quantity must be not null")
    @Column(columnDefinition = "integer not null")
    private Integer quantity;

    @Column(columnDefinition = "varchar(15) not null default 'waiting' check(status = 'waiting' or status = 'confirm' or status = 'reject')")
    private String status;

    @Column(columnDefinition = "integer not null")
    private Integer total;

    @NotEmpty(message = "location must be not null")
    @Column(columnDefinition = "varchar(30) not null")
    private String location;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime order_date;


    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Product product;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orders")
    private Invoice invoice;

}
