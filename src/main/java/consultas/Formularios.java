package consultas;

import preguntas.Pregunta;
import respuestas.RespuestaPregunta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Formularios extends Consulta{
  List<Pregunta> preguntasObl = new ArrayList<>();
  List<Pregunta> preguntasOpc = new ArrayList<>();

  @Override
  public boolean esEncuesta() {
    return false;
  }

  @Override
  protected void consultaFinalizada() {

  }

  @Override
  public boolean respondidaAdecuadamente(List<RespuestaPregunta> respuestas) {
    List<Pregunta> preguntasRespondidas = respuestas.stream().map(RespuestaPregunta::getPregunta).collect(Collectors.toList());
    respuestas.stream().forEach(RespuestaPregunta::respondidaAdecuadamente);
    return preguntasRespondidas.containsAll(preguntasObl);
  }

}
