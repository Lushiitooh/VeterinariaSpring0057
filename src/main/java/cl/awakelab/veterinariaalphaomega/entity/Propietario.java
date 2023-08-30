package cl.awakelab.veterinariaalphaomega.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Propietarios")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length =75)
    private String nombre;

    @Column(length = 30)
    private String apellido;

    @Column(length = 30)
    private String telefono;

    @Column(length = 50)
    private String correoElectronico;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Usuario", nullable = false)
    private Usuario idUsuario;


}
