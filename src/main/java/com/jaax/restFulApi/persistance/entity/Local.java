package com.jaax.restFulApi.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "locals")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Please add the name")
    private String name;
    private String floor;
    private String code;
}
