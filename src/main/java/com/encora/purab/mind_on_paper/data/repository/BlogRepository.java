package com.encora.purab.mind_on_paper.data.repository;

import com.encora.purab.mind_on_paper.data.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
