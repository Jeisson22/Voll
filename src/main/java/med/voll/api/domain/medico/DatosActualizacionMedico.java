package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosActualizacionMedico(
        // Aca se coloca los datos que podemos recibir del PUT
        @NotNull  Long id,
        String nombre,
        String telefono,
        // Una observacion es que utilizamos el DTO DatosDireccion porque ya tiene restriccion que mejora el proyecto
        DatosDireccion direccion
) {
}
