package consultas;

import excepciones.NoPreguntasAbiertasEnEncuesta;
import preguntas.Pregunta;
import preguntas.PreguntaMultiValuada;
import preguntas.PreguntaTextoLibre;
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

}
