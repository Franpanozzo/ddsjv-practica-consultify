package respuestas;

import consultas.Consulta;

import java.util.ArrayList;
import java.util.List;

public class RespuestaConsulta {
  Consulta consulta;
  String email;
  List<RespuestaPregunta> respuestas = new ArrayList<>();

  public String getEmail() {
    return email;
  }

  public boolean fueRespondidaAdecuadamente() {
    return consulta.respondidaAdecuadamente(respuestas);
  }

  public boolean respondeConsulta(Consulta consulta) {
    return this.consulta.equals(consulta);
  }
}
