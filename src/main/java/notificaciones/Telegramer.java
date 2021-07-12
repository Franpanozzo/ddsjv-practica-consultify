package notificaciones;

import utils.SuscriptorDTO;
import utils.TelegramSender;

public class Telegramer implements FormaDeNotificar{
  TelegramSender telegramSender = new TelegramSender();

  @Override
  public void notificar(String contenido, SuscriptorDTO suscriptorDTO) {
    telegramSender.enviar(suscriptorDTO.telephone() , contenido);
  }
}
