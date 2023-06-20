package com.jaax.restFulApi.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Table(name = "locals")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString(exclude = "manager") //Excluir atributos en manager
public class Local {
    @Id
    @SequenceGenerator(
            name = "local_sequence",
            sequenceName = "local_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "local_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long localId;
    @NotBlank(message = "Please add the name")
    private String name;
    private String floor;
    private String code;

    @OneToOne(cascade = CascadeType.PERSIST,
       // fetch = FetchType.LAZY  //LAZY: Consultar solo info de la entidad padre
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"

    )
    private Manager manager;

    @OneToMany
    @JoinColumn(
            name = "local_id", //Nombre en base de datos
            referencedColumnName = "localId" //Referencia llave primaria
    )
    private List<Order> orderList;
}
