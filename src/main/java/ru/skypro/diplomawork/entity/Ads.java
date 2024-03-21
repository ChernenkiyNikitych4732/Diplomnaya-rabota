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
    private Integer price;
    @Column(name = "ad_title")
    private String title;
    @Column(name = "ads_description")
    private String description;
    @Column(name = "image_path")
    private String imagePath;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;
    @OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
    private List<Comments> comments;
}