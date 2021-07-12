package pausados;

import consultas.Consulta;

import java.time.LocalDateTime;

public class CriterioFecha implements CriterioPausa{
  LocalDateTime fechaReactivacion;

  @Override
  public void chequearReactivacion(Consulta consulta) {
    if(LocalDateTime.now().isAfter(fechaReactivacion))
      consulta.despausar();
  }

  @Override
  public boolean permitirDespausaManual() {
    return false;
  }
}
