package cl.awakelab.veterinariaalphaomega.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    private int id;

    @Column(name = "nombre_usuario", unique = true, length = 50)
    private String nombreUsuario;

    @Column(length = 30)
    private String contrasena;

    @Column(length = 30)
    private String rol;

    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Veterinario veterinario;

    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Propietario propietario;
}
