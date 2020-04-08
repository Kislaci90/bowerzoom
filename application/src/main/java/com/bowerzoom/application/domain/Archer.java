package com.bowerzoom.application.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "Archer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Archer extends BaseEntity {

    @Column()
    private String name;

    private Instant birthDate;

    @Column(unique = true)
    private String email;

    private Gender gender;

}
