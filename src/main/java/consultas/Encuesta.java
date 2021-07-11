package consultas;

import excepciones.NoPreguntasAbiertasEnEncuesta;
import preguntas.Pregunta;
import preguntas.PreguntaTextoLibre;

public class Encuesta extends Consulta {
  Pregunta pregunta;

  public Encuesta(Pregunta pregunta) {
    this.pregunta = this.chequearNoEsAbierta(pregunta);
  }

  @Override
  public boolean todasRespondidas() {
    return pregunta.tieneRespuesta();
  }

  public Pregunta chequearNoEsAbierta(Pregunta pregunta) {
    if (pregunta.getTipoPregunta().toString().equals(PreguntaTextoLibre.class.toString())) {
        throw new NoPreguntasAbiertasEnEncuesta("No puede haber preguntas habiertas en encuestas");
    }
    return pregunta;
  }

}
