package consultas;

import pausados.CriterioPausa;
import respuestas.RespuestaPregunta;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class Consulta {
  String link;
  LocalDateTime limite;
  Duration duracionFaltante;
  boolean pausada = false;
  CriterioPausa criterioPausa;

  public boolean tieneLink(String link) {
    return this.link.equals(link);
  }

  public String getLink() {
    return link;
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

  public void despausarManualmente() {
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

  public void chequearFinalizacion() {
    if(LocalDateTime.now().isAfter(limite))
      this.consultaFinalizada();
  }

  public abstract boolean esEncuesta();

  protected abstract void consultaFinalizada();

  public abstract boolean respondidaAdecuadamente(List<RespuestaPregunta> respuestas);
}





