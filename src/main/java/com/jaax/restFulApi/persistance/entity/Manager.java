package com.jaax.restFulApi.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Manager {
    @Id
    @SequenceGenerator(
            name = "manager_sequence",
            sequenceName = "manager_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "manager_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long managerId;
    private String firstName;
    private String lastName;

    /**
     * Bidireccionalidad local - manager
     */
    @OneToOne(
            mappedBy ="manager",
            fetch =FetchType.EAGER
    )
    private Local local;
}

