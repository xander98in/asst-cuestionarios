package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output;

public interface CuestionarioFormateadorResultadosIntPort {

    public void retornarRespuestaErrorEntidadExistente(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);

}
