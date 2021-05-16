package com.example.carrentalproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "banner")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    private String name;
    private String photo;
    private Date createdAt;
}
