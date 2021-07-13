package consultas;

import finalizacionObservers.FinalizacionObserver;
import preguntas.PreguntaMultiValuada;
import preguntas.RespuestaPosible;
import respuestas.RespuestaPregunta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Encuesta extends Consulta {
  PreguntaMultiValuada pregunta;
  List<FinalizacionObserver> finalizacionObservers = new ArrayList<>();


  public Encuesta(PreguntaMultiValuada pregunta) {
    this.pregunta = pregunta;
  }

  //Adentro los valoresposibles tiene la cantidad de elecciones para esa opcion
  public List<RespuestaPosible> resultadosEncuesta() {
    return pregunta.getValoresPosibles();
  }

  @Override
  protected void consultaFinalizada() {
      finalizacionObservers.forEach(finalizacionObserver -> finalizacionObserver.encuestaFinalizada(this));
  }

  @Override
  public boolean respondidaAdecuadamente(List<RespuestaPregunta> respuestas) {
    RespuestaPregunta respuestaPregunta = respuestas.get(0);
    return pregunta.esRespuestaPosible(respuestaPregunta.getRespuesta());
  }

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
