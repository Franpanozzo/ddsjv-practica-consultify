package consultas;

import finalizacionObservers.FinalizacionObserver;
import pausados.CriterioPausa;
import utils.DatoDeContacto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Consulta {
  String link;
  LocalDateTime limite;
  Duration duracionFaltante;
  boolean pausada = false;
  CriterioPausa criterioPausa;
  List<DatoDeContacto> datoDeContactoParticipantes;
  List<FinalizacionObserver> finalizacionObservers = new ArrayList<>();

  public boolean tieneLink(String link) {
    return this.link.equals(link);
  }

  public String getLink() {
    return link;
  }

  public void nuevoParticipante(DatoDeContacto datoDeContacto) {
    datoDeContactoParticipantes.add(datoDeContacto);
  }

  public int cantidadRespuestas() {
    return datoDeContactoParticipantes.size();
  }

  public void pausar() {
    pausada = true;
    duracionFaltante = Duration.ofMinutes(LocalDateTime.now().until(limite, ChronoUnit.MINUTES));
    //Aca nose si se puede decirle al cron que llame al metodo this.cehquearReactivacion()
    //cada un minuto, sino bueno que se haga siempre
  }

  public List<DatoDeContacto> getDatoDeContactoParticipantes() {
    return datoDeContactoParticipantes;
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

  public void chequearFinalizacion(){
    if(LocalDateTime.now().isAfter(limite))
      finalizacionObservers.forEach(finalizacionObserver -> finalizacionObserver.consultaFinalizada(this));
  }

  public abstract String respuestas();

  public abstract boolean esEncuesta();
}





