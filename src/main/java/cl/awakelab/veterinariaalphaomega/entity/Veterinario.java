package cl.awakelab.veterinariaalphaomega.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "veterinario")

public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column (nullable = false,length = 75)
    private String nombres;

    @Column (nullable = false,length = 50)
    private String apellido1;

    @Column (nullable = false,length = 50)
    private String apellido2;

    @Column (nullable = false,length = 50)
    private String especialidad;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Usuario", nullable = false)
    private Usuario usuario;
//TODO muchos veterinarios pueden atender muchas mascotas


}
