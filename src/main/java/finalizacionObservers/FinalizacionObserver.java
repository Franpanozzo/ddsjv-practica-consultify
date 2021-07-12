package finalizacionObservers;

import consultas.Consulta;
import utils.DatoDeContacto;

import java.util.List;

public interface FinalizacionObserver {
  void consultaFinalizada(Consulta consulta);
}
