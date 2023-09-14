package cl.awakelab.veterinariaalphaomega.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Mascotas")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 75)
    private String nombre;

    @Column(length = 30)
    private String fechaNac;

    @Column(length = 30)
    private String especie;

    @Column(length = 30)
    private String raza;

    @Column(length = 30)
    private String color;

    @ManyToOne(optional = false,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "propietario_id", referencedColumnName = "id", nullable = false)
    private Propietario propietarioMascota;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name = "Paciente_Veterinario",
            joinColumns = @JoinColumn(name = "FK_Veterinario", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_Paciente", nullable = false))
    private Veterinario veterinarioAsignado;
}
