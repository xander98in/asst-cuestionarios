package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output;

public interface FormateadorResultadosIntPort {

    public void retornarRespuestaErrorEntidadExistente(String mensaje);

    public void retornarRespuestaErrorEntidadNoExistente(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);

}
