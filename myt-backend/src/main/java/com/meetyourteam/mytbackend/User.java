package com.meetyourteam.mytbackend;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "sequence-generator",allocationSize = 1, sequenceName = "sequence-generator")
    @GeneratedValue(generator = "sequence-generator", strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 500, nullable = false)
    private String profilePictureUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "parentUser")
    private Set<User> linkedUsers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentUser")
    private User parentUser;

}
