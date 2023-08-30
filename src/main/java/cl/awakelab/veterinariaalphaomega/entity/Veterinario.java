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

    @Column(name = "usuarioId", unique = true, nullable = false)
    private int usuarioId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK, Usuario", nullable = false)
    private Usuario usuario;


}
