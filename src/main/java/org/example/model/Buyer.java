package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_buyer")
    List<Product> products = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    List<Card7> cards = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    List<VipCard> vipCards = new ArrayList<>();

}
