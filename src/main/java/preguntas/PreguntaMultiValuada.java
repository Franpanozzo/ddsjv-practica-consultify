package preguntas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Una pregunta binaria es una multivaluada pero que ingresen el SI y NO nomas como valoresPosibles;
public class PreguntaMultiValuada implements TipoPregunta{
  List<String> valoresPosibles = new ArrayList<>();

  @Override
  public boolean esRespuestaPosible(String respuesta) {
    return valoresPosibles.contains(respuesta);
  }

  public void setearPreguntaBooleana() {
    valoresPosibles.addAll(Arrays.asList("SI","NO"));
  }

  @Override
  public boolean esAbierta() {
    return false;
  }

}
