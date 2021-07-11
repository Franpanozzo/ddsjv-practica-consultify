package preguntas;

public class RespuestaPosible {
  public String posibleRespuesta;
  public int vecesElegida;

  public boolean esPosibleRespuesta(String posibleRespuesta) {
    return this.posibleRespuesta.equals(posibleRespuesta);
  }

  public int getVecesElegida() {
    return vecesElegida;
  }

  public void elegida() {
    vecesElegida++;
  }
}