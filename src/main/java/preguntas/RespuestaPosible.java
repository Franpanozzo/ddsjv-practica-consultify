package preguntas;

public class RespuestaPosible {
  public String posibleRespuesta;
  public int vecesElegida;

  public RespuestaPosible(String posibleRespuesta, int vecesElegida) {
    this.posibleRespuesta = posibleRespuesta;
    this.vecesElegida = vecesElegida;
  }

  public boolean esPosibleRespuesta(String posibleRespuesta) {
    if(this.posibleRespuesta.equals(posibleRespuesta)) {
      this.elegida();
      return true;
    }
    return false;
  }

  public void elegida() {
    vecesElegida++;
  }
}