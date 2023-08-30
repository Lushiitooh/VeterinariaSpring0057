package cl.awakelab.veterinariaalphaomega.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mascotas")

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

    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "propietario_id", referencedColumnName = "id")
    private Propietario propietarioMascota;


}
