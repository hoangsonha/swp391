package com.group6.swp391.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackID;

    @Column(name = "comment", length = 1024)
    private String comment;

    private double rating;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
//    private Order order;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "diamond_id")
    private Diamond diamond;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    public Feedback(String comment, double rating, Diamond diamond, Product product) {
        this.comment = comment;
        this.rating = rating;
        this.diamond = diamond;
        this.product = product;
    }
}
