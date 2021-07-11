package consultas;

import preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class Formularios extends Consulta{
  List<Pregunta> preguntasObl = new ArrayList<>();
  List<Pregunta> preguntasOpc = new ArrayList<>();

  public boolean todasRespondidas() {
    return preguntasObl.stream().allMatch(Pregunta::tieneRespuesta);
  }

}
