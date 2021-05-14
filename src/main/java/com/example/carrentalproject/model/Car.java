package com.example.carrentalproject.model;

import com.example.carrentalproject.util.FuelType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "cars")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    private String name;
    private int passengers;
    private int doors;
    private String engine;
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String photo;
    private int price;
    private String location;
    private boolean featured;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandId", insertable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Brand brand;

    private int brandId;
}
