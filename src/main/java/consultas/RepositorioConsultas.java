package consultas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioConsultas {
  List<Consulta> consultas = new ArrayList<>();

  public Consulta buscarConsulta(String link) {
    return consultas.stream().filter(consulta -> consulta.tieneLink(link)).findAny().get();
  }
}
