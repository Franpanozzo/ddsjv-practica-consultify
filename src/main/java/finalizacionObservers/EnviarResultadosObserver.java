package finalizacionObservers;

import consultas.Encuesta;
import notificaciones.FormaDeNotificar;
import notificaciones.Mailer;
import notificaciones.Telegramer;
import utils.SuscriptorDTO;
import utils.SuscriptoresSystem;

public class EnviarResultadosObserver implements FinalizacionObserver{
  SuscriptoresSystem suscriptoresSystem = new SuscriptoresSystem();
  FormaDeNotificar formaDeNotificar;

  public void setFormaDeNotificar(FormaDeNotificar formaDeNotificar) {
    this.formaDeNotificar = formaDeNotificar;
  }

  @Override
  public void encuestaFinalizada(Encuesta encuesta) {
    encuesta.getMailsParticipantes().forEach(mail -> this.enviarNotificacion(mail,encuesta.respuestas()));
  }

  private void enviarNotificacion(String mail, String respuestas) {
    SuscriptorDTO suscriptorDTO = suscriptoresSystem.findByMail(mail);
    this.setearFormaDeNotificar(suscriptorDTO);
    formaDeNotificar.notificar(respuestas, suscriptorDTO);
  }

  private void setearFormaDeNotificar(SuscriptorDTO suscriptorDTO) {
    if(suscriptorDTO.notifyByMail()) {
      setFormaDeNotificar(new Mailer());
    }
    else {
      setFormaDeNotificar(new Telegramer());
    }
  }
}
