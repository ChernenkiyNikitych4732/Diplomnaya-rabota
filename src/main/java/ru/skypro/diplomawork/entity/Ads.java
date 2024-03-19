package ru.skypro.diplomawork.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "ads")
public class Ads {
    @Id
    @Column(name = "ad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ad_price")
    private BigDecimal price;
    private String title;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    @OneToMany(mappedBy = "ads", cascade = CascadeType.ALL)
    private List<Comments> comments;
    @OneToMany(mappedBy = "ads", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Image> images;
}