package notificaciones;

import utils.SuscriptorDTO;

public interface FormaDeNotificar {
  void notificar(String contenido, SuscriptorDTO suscriptorDTO);
}
