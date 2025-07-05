package med.voll.medico;

import med.voll.direccion.Direccion;

public record DatosRegistroMedico(String nombre, String email, String documento, Especialidad  especialidad, Direccion direccion) {


}
