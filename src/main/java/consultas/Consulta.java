package consultas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Consulta {
  String link;
  LocalDateTime limite;
  Duration duracionFaltante;
  boolean pausada = false;

  public boolean tieneLink(String link) {
    return this.link.equals(link);
  }

  public void pausar() {
    pausada = true;
    duracionFaltante = Duration.ofMinutes(LocalDateTime.now().until(limite, ChronoUnit.MINUTES));
  }

  public void despausar() {
    pausada = false;
    limite = LocalDateTime.now().plusMinutes(duracionFaltante.toMinutes());
  }

  public boolean esAccesible() {
    return !pausada && LocalDateTime.now().isBefore(limite);
  }

  public abstract boolean todasRespondidas();
}
