package respuestas;

import consultas.Consulta;
import consultas.Encuesta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioRespuestas {
  List<RespuestaConsulta> respuestaConsultas = new ArrayList<>();
  private static RepositorioRespuestas instance = new RepositorioRespuestas();

  public static RepositorioRespuestas getInstance() {
    return instance;
  }

  public int cantRespuestas(Consulta consulta) {
    return this.respondieronConsulta(consulta).size();
  }

  public List<RespuestaConsulta> respondieronConsulta(Consulta consulta) {
    return respuestaConsultas.stream().filter(respuestaConsulta -> respuestaConsulta.respondeConsulta(consulta)).collect(Collectors.toList());
  }

  public List<String> mailsQueRespondieron(Encuesta encuesta) {
    return this.respondieronConsulta(encuesta).stream().map(RespuestaConsulta::getEmail).collect(Collectors.toList());
  }
}
