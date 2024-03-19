package ru.skypro.diplomawork.entity;

import lombok.Data;
import ru.skypro.diplomawork.dto.Role;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @Column(name = "ad_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Long_id")
    private String firstName;
    private String lastName;
    private String username;
    private String phone;
    private String city;
    private LocalDateTime regDate;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Avatar avatar;
    @OneToMany(mappedBy = "author")
    private List<Ads> adsList;
}