package excepciones;

public class NoPreguntasAbiertasEnEncuesta extends RuntimeException{
  public NoPreguntasAbiertasEnEncuesta(String message) {
    super(message);
  }
}
