package consultas;

import preguntas.PreguntaMultiValuada;
import preguntas.RespuestaPosible;

import java.util.List;

public class Encuesta extends Consulta {
  PreguntaMultiValuada pregunta;

  public Encuesta(PreguntaMultiValuada pregunta) {
    this.pregunta = pregunta;
  }

  //Adentro los valoresposibles tiene la cantidad de elecciones para esa opcion
  public List<RespuestaPosible> resultadosEncuesta() {
    return pregunta.getValoresPosibles();
  }

  @Override
  public String respuestas() {
    return this.resultadosEncuesta().toString();
  }

  @Override
  public boolean esEncuesta() {
    return true;
  }

  public String preguntaTextual() {
    return pregunta.getPregunta();
  }
}
