package finalizacionObservers;

import consultas.Consulta;
import notificaciones.FormaDeNotificar;
import utils.DatoDeContacto;
import utils.SuscriptorDTO;
import utils.SuscriptoresSystem;

import java.util.List;

public class EnviarResultadosObserver implements FinalizacionObserver{
  SuscriptoresSystem suscriptoresSystem = new SuscriptoresSystem();
  FormaDeNotificar formaDeNotificar;

  public EnviarResultadosObserver(FormaDeNotificar formaDeNotificar) {
    this.formaDeNotificar = formaDeNotificar;
  }

  @Override
  public void consultaFinalizada(Consulta consulta) {
    consulta.getDatoDeContactoParticipantes().forEach(datoDeContacto -> this.enviarNotificacion(datoDeContacto,consulta.respuestas()));
  }

  private void enviarNotificacion(DatoDeContacto datoDeContacto, String respuestas) {
    SuscriptorDTO suscriptorDTO = suscriptoresSystem.findByMail(datoDeContacto.getMail());
    formaDeNotificar.notificar(datoDeContacto, respuestas, suscriptorDTO);
  }
}
