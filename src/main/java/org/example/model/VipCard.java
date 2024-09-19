package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class VipCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ElementCollection
    private List<String> discountProducts = new ArrayList<>();
    private int discountPercent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_owner")
    Buyer owner;
}
