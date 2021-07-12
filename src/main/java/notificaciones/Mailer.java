package notificaciones;

import utils.MailSender;
import utils.SuscriptorDTO;

public class Mailer implements FormaDeNotificar{
  MailSender mailer = new MailSender();
  String emailActual;

  @Override
  public void notificar(String contenido, SuscriptorDTO suscriptorDTO) {
    mailer.send(emailActual, suscriptorDTO.mail(), contenido);
  }
}
