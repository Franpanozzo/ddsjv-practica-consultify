package preguntas;

public class PreguntaTextoLibre implements TipoPregunta{
  String pregunta;

  @Override
  public boolean esRespuestaPosible(String respuesta) {
    return true;
  }

  @Override
  public boolean esAbierta() {
    return true;
  }

}
