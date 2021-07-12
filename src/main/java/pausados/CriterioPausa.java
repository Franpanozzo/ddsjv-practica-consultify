package pausados;

import consultas.Consulta;

public interface CriterioPausa {
  void chequearReactivacion(Consulta consulta);

  boolean permitirDespausaManual();
}
