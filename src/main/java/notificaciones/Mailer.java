package notificaciones;

import utils.DatoDeContacto;
import utils.MailSender;
import utils.SuscriptorDTO;

public class Mailer implements FormaDeNotificar{
  MailSender mailer = new MailSender();
  String emailActual;

  @Override
  public void notificar(DatoDeContacto datoDeContacto, String contenido, SuscriptorDTO suscriptorDTO) {
    mailer.send(emailActual, datoDeContacto.getMail(), contenido);
    suscriptorDTO.notifyByMail();
  }
}
