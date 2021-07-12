package consultas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioConsultas {
  List<Consulta> consultas = new ArrayList<>();

  public Consulta buscarConsulta(String link) {
    return consultas.stream().filter(consulta -> consulta.tieneLink(link)).findAny().get();
  }

  //Metodo que se llama desde un cron a este repositorio cada 1 minuto
  public void chequearFinalizacion() {
    consultas.forEach(Consulta::chequearFinalizacion);
  }
}
