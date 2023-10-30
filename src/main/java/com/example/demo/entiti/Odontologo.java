package com.example.demo.entiti;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "odontologo")
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologos_id", sequenceName = "odontologos_id",
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private Integer matricula;

    public Odontologo() {}

    @Autowired
    public Odontologo(String nombre, String apellido, Integer matricula, Set<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.turnos = turnos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="odontologo", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;



}
