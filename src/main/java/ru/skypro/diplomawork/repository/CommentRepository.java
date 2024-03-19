package ru.skypro.diplomawork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.diplomawork.entity.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
}
