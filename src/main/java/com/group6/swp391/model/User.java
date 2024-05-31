package com.group6.swp391.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @Column(name = "first_name", columnDefinition = "varchar(300)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "varchar(300)")
    private String lastName;
    @Column(name = "email", nullable = false, length = 200, unique = true)
    private String email;
    @Column(name = "password", nullable = false, length = 200)
    private String password;
    @Column(name = "phone", length = 20)
    private String phone;
    @Column(name = "address", columnDefinition = "varchar(300)")
    private String address;
    @Column(name = "avata")
    private String avata;
    @Column(name = "code_verify", nullable = false)
    private String codeVerify;
    private boolean enabled;
    private boolean looked;

    @ManyToOne
    @JoinColumn(name = "roleID")
    private Role role;

    public User(String firstName, String lastName, String email, String password, String phone, String address, String avata, String codeVerify, boolean enabled, boolean looked, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.avata = avata;
        this.codeVerify = codeVerify;
        this.enabled = enabled;
        this.looked = looked;
        this.role = role;
    }
}
