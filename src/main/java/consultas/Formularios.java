package consultas;

import preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Formularios extends Consulta{
  List<Pregunta> preguntasObl = new ArrayList<>();
  List<Pregunta> preguntasOpc = new ArrayList<>();

  public boolean todasRespondidas() {
    return preguntasObl.stream().allMatch(Pregunta::tieneRespuesta);
  }

  @Override
  public String respuestas() {
    return preguntasObl.stream().map(Pregunta::getRespuesta).collect(Collectors.toList()).toString();
  }

  @Override
  public boolean esEncuesta() {
    return false;
  }

  @Override
  protected void consultaFinalizada() {

  }

}
