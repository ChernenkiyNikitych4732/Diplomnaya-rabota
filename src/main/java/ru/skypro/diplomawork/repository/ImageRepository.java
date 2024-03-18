package ru.skypro.diplomawork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.diplomawork.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
