package pausados;

import consultas.Consulta;

public class CriterioUsuario implements CriterioPausa{
  @Override
  public void chequearReactivacion(Consulta consulta) {

  }

  @Override
  public boolean permitirDespausaManual() {
    return true;
  }
}
