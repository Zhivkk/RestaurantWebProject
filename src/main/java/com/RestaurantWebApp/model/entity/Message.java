package com.RestaurantWebApp.model.entity;

import com.dictionaryapp.model.entity.enums.MessageStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String subject;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String messageText;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageStatus messageStatus;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime dateOfAnswer;

}

//User user; - името на клиента (логнатия в системата)
//String subject;
//Text messageText;
//String messageStatus; written, read, replied, deleted
//LocalDateTime creationDate;
//LocalDateTime dateOfAnswer;
