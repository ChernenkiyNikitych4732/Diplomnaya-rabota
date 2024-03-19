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
    BigDecimal price;
    String title;
    String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User author;
    @OneToMany(mappedBy = "ads", cascade = CascadeType.ALL)
    List<Comments> comments;
    @OneToMany(mappedBy = "ads", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Image> images;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}