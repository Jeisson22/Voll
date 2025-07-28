package med.voll.api.medico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;
import med.voll.api.paciente.DatosResgistroPaciente;

import java.awt.*;


// Importa las anotaciones de Lombok y JPA necesarias
@Getter // Genera automáticamente métodos getter para todos los atributos
@EqualsAndHashCode(of = "id") // Genera equals() y hashCode() usando solo el campo "id"
@NoArgsConstructor // Genera un constructor vacío (requerido por JPA)
@AllArgsConstructor // Genera un constructor con todos los campos
@Entity(name = "Paciente") // Marca esta clase como una entidad JPA (mapeada a una tabla)
@Table(name = "pacientes") // Define el nombre de la tabla en la base de datos
public class Paciente {

    // Indica que este es el ID (clave primaria) de la entidad
    @Id
    // Configura la generación automática del ID (auto-increment en BD)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo que se guardará en la tabla como columna "nombre"
    private String nombre;

    // Campo que se guardará en la tabla como columna "email"
    private String email;

    // Documento de identidad del paciente
    private String documento;

    // Teléfono del paciente
    private String telefono;

    // Marca que este atributo es un objeto embebido (se guardará en la misma tabla)
    @Embedded
    private Direccion direccion;

    // Constructor personalizado que recibe un objeto DTO (DatosRegistroPaciente)
    public Paciente(DatosResgistroPaciente datos) {
        // Asigna el nombre recibido desde el DTO
        this.nombre = datos.nombre();
        // Asigna el email recibido desde el DTO
        this.email = datos.email();
        // Asigna el teléfono recibido desde el DTO
        this.telefono = datos.telefono();
        // Asigna el documento de identidad recibido desde el DTO
        this.documento = datos.documento();
        // Crea una nueva dirección a partir de los datos del DTO
        this.direccion = new Direccion(datos.direccion());
    }
}

