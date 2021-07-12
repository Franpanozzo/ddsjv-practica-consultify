package finalizacionObservers;

import consultas.Consulta;
import consultas.Encuesta;
import utils.ComunicadorConSistemaDeReporting;

public class ReportarRespuestasObserver implements FinalizacionObserver{
  ComunicadorConSistemaDeReporting comunicador = new ComunicadorConSistemaDeReporting();

  @Override
  public void encuestaFinalizada(Encuesta encuesta) {
      comunicador.agregarNuevaEncuesta(encuesta.getLink(), encuesta.cantidadRespuestas());
      comunicador.agregarRespuesta(encuesta.preguntaTextual(), encuesta.resultadosEncuesta().toString());
      comunicador.enviarRespuestas();
  }
}
