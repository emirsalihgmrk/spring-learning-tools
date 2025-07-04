package com.example.springbootlibrary.dao;

import com.example.springbootlibrary.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findByUserEmail(@RequestParam("email") String email, Pageable pageable);
    Page<Message> findByClosed(@RequestParam("closed") boolean closed,Pageable pageable);
}
