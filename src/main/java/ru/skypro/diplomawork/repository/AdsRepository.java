package ru.skypro.diplomawork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.diplomawork.entity.Ads;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
    List<Ads> findAdsByAuthorUsername(String email);
}
