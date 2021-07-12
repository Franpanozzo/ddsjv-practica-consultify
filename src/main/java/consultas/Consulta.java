package consultas;

import pausados.CriterioPausa;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Consulta {
  String link;
  LocalDateTime limite;
  Duration duracionFaltante;
  boolean pausada = false;
  CriterioPausa criterioPausa;

  public boolean tieneLink(String link) {
    return this.link.equals(link);
  }

  public void pausar() {
    pausada = true;
    duracionFaltante = Duration.ofMinutes(LocalDateTime.now().until(limite, ChronoUnit.MINUTES));
    //Aca nose si se puede decirle al cron que llame al metodo this.cehquearReactivacion()
    //cada un minuto, sino bueno que se haga siempre
  }

  public void chequearReactivacion() {
    criterioPausa.chequearReactivacion(this);
  }

  public void pausarManualmente() {
    if(criterioPausa.permitirDespausaManual()) {
      this.despausar();
    }
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
