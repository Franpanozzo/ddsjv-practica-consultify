package finalizacionObservers;

import consultas.Encuesta;

public interface FinalizacionObserver {
  void encuestaFinalizada(Encuesta encuesta);
}
