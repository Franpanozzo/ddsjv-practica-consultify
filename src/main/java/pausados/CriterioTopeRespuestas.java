package pausados;

import consultas.Consulta;
import respuestas.RepositorioRespuestas;

public class CriterioTopeRespuestas implements CriterioPausa{
  int respuestasEsperadas;

  @Override
  public void chequearReactivacion(Consulta consulta) {
    //Nose como pero la cantidad de respuestas se registran en una base de datos y de alguna manera se puede saber
    //cuantas se registraron
    if(RepositorioRespuestas.getInstance().cantRespuestas(consulta) > respuestasEsperadas)
      consulta.despausar();
  }

  @Override
  public boolean permitirDespausaManual() {
    return false;
  }
}
