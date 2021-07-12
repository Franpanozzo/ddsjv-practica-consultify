package notificaciones;

import utils.DatoDeContacto;
import utils.SuscriptorDTO;
import utils.TelegramSender;

public class Telegramer implements FormaDeNotificar{
  TelegramSender telegramSender = new TelegramSender();

  @Override
  public void notificar(DatoDeContacto datoDeContacto, String contenido, SuscriptorDTO suscriptorDTO) {
    telegramSender.enviar(datoDeContacto.getNumeroTelefono(), contenido);
    suscriptorDTO.notifyByTelegram();
  }
}
