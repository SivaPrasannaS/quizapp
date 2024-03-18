package com.maxneo.quizapp.model;

import static com.maxneo.quizapp.enumerated.TokenType.BEARER;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.UUID;

import com.maxneo.quizapp.enumerated.TokenType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_token")
public class Token {
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;

    @Column(unique = true)
    private String token;

    @Builder.Default
    @Enumerated(STRING)
    private TokenType tokenType = BEARER;
    private boolean revoked;
    private boolean expired;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
