package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank String telefono,
        @NotBlank  @Pattern(regexp = "\\d{8}") String documento,
        // Notblanck no sirver pára tipo de dato enum
        // solo Notblanck con string
        @NotNull    Especialidad  especialidad,
        @NotNull @Valid DatosDireccion direccion) {



}
