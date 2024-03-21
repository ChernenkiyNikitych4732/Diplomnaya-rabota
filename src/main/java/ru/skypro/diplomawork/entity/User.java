package ru.skypro.diplomawork.entity;

import lombok.Data;
import ru.skypro.diplomawork.dto.Role;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String username;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role role;
    @OneToMany(mappedBy = "author")
    private List<Ads> adsList;
}