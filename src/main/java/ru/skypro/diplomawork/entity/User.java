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
    String firstName;
    String lastName;
    String username;
    String phone;
    String city;
    LocalDateTime regDate;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    Avatar avatar;
    @OneToMany(mappedBy = "author")
    List<Ads> adsList;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}