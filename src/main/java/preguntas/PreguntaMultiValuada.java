package preguntas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Una pregunta binaria es una multivaluada pero que ingresen el SI y NO nomas como valoresPosibles;
public class PreguntaMultiValuada implements TipoPregunta{
  String pregunta;
  List<RespuestaPosible> valoresPosibles = new ArrayList<>();

  public String getPregunta() {
    return pregunta;
  }

  @Override
  public boolean esRespuestaPosible(String respuesta) {
    return valoresPosibles.stream().anyMatch(respuestaPosible -> respuestaPosible.esPosibleRespuesta(respuesta));
  }

  public void setearPreguntaBooleana() {
    valoresPosibles.addAll(Arrays.asList(new RespuestaPosible("SI",0),new RespuestaPosible("NO",0)));
  }

  public List<RespuestaPosible> getValoresPosibles() {
    return valoresPosibles;
  }

  @Override
  public boolean esAbierta() {
    return false;
  }

}
