package preguntas;

import excepciones.NoEsRespuestaValidaException;

import java.util.Locale;

public class Pregunta {
  TipoPregunta tipoPregunta;

  public void responderPregunta(String respuesta) {
    String respuestaEnSist = respuesta.toUpperCase(Locale.ROOT);
    this.chequearRespuestaPosible(respuestaEnSist);
  }

  public TipoPregunta getTipoPregunta() {
    return tipoPregunta;
  }

  private void chequearRespuestaPosible(String respuesta) {
    if(!tipoPregunta.esRespuestaPosible(respuesta)) {
      throw new NoEsRespuestaValidaException("La respuesta no es valida");
    }
  }

  public boolean esAbierta() {
    return tipoPregunta.esAbierta();
  }
}
