package ru.skypro.diplomawork.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "comments")
public class Comment {
    @Column(name = "ad_comments")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Column(name = "ad_text")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ads ad;

    @ManyToOne
    private Ads ads;
}
