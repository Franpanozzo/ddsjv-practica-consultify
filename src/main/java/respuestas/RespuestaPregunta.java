package respuestas;

import preguntas.Pregunta;

public class RespuestaPregunta {
  Pregunta pregunta;
  String respuesta;

  public String getRespuesta() {
    return respuesta;
  }

  public Pregunta getPregunta() {
    return pregunta;
  }

  public void respondidaAdecuadamente() {
    pregunta.responderPregunta(respuesta);
  }
}
