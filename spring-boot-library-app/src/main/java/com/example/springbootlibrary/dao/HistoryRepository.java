package com.example.springbootlibrary.dao;

import com.example.springbootlibrary.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface HistoryRepository extends JpaRepository<History,Long> {
    Page<History> findBooksByUserEmail(@RequestParam("email") String email, Pageable pageable);
}
