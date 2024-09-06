package com.games.core_games.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "TB_USERS")
@Getter @Setter
public class UserEntity {
    @Id()
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_verified_account")
    private Boolean userVerifiedAccount;
}
