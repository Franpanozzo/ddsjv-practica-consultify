package preguntas;

public class PreguntaTextoLibre implements TipoPregunta{
  String respuesta;

  @Override
  public boolean esRespuestaPosible(String respuesta) {
    return true;
  }

  @Override
  public void registrarRespuesta(String respuesta) {
    this.respuesta = respuesta;
  }
}
