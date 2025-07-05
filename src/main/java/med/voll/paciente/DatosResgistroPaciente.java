package med.voll.paciente;

import med.voll.direccion.Direccion;

public record DatosResgistroPaciente(String nombre, String email, String telefono, String documento, Direccion direccion) {
}
