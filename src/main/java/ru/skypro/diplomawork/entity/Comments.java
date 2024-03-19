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
    private String text;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ads ad;
    @ManyToOne
    private Ads ads;
}