package ru.skypro.diplomawork.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "comment")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comment_text")
    String text;
    LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User author;
    @ManyToOne
    @JoinColumn(name = "ad_id")
    Ads ad;
    @ManyToOne
    Ads ads;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}