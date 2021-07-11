package preguntas;

import java.util.ArrayList;
import java.util.List;

//Una pregunta binaria es una multivaluada pero que ingresen el SI y NO nomas como valoresPosibles;
public class PreguntaMultiValuada implements TipoPregunta{
  List<RespuestaPosible> valoresPosibles = new ArrayList<>();

  @Override
  public boolean esRespuestaPosible(String respuesta) {
    return valoresPosibles.stream().anyMatch(respuestaPosible -> respuestaPosible.esPosibleRespuesta(respuesta));
  }

  public void registrarRespuesta(String respuesta) {
    this.respuestaPosible(respuesta).elegida();
  }

  @Override
  public boolean noEstaVacia() {
    return false;
  }

  public RespuestaPosible respuestaPosible(String respuesta) {
    return valoresPosibles.stream().filter(respuestaPosible -> respuestaPosible.esPosibleRespuesta(respuesta)).findAny().get();
  }
}
