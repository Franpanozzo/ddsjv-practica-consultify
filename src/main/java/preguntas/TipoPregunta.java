package preguntas;

public interface TipoPregunta {

  boolean esRespuestaPosible(String respuesta);

  void registrarRespuesta(String respuesta);

  boolean noEstaVacia();
}
