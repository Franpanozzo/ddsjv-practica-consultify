package pausados;

import consultas.Consulta;

public class CriterioTopeRespuestas implements CriterioPausa{
  int respuestasEsperadas;

  @Override
  public void chequearReactivacion(Consulta consulta) {
    //Nose como pero la cantidad de respuestas se registran en una base de datos y de alguna manera se puede saber
    //cuantas se registraron
    if(baseDeDatos.cantRespuestas(consulta) > respuestasEsperadas)
      consulta.despausar();
  }

  @Override
  public boolean permitirDespausaManual() {
    return false;
  }
}
