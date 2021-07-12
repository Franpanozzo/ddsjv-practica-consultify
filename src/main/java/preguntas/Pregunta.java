package preguntas;

import excepciones.NoEsRespuestaValidaException;

import java.util.Locale;

public class Pregunta {
  TipoPregunta tipoPregunta;
  String respuesta;

  public String getRespuesta() {
    return respuesta;
  }

  public void responderPregunta(String respuesta) {
    String respuestaEnSist = respuesta.toUpperCase(Locale.ROOT);
    this.chequearRespuestaPosible(respuestaEnSist);
    this.respuesta = respuestaEnSist;
  }

  public TipoPregunta getTipoPregunta() {
    return tipoPregunta;
  }

  private void chequearRespuestaPosible(String respuesta) {
    if(!tipoPregunta.esRespuestaPosible(respuesta)) {
      throw new NoEsRespuestaValidaException("La respuesta no es valida");
    }
  }

  public boolean tieneRespuesta() {
    return !respuesta.isEmpty();
  }

  public boolean esAbierta() {
    return tipoPregunta.esAbierta();
  }
}
