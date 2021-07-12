package notificaciones;

import utils.DatoDeContacto;
import utils.SuscriptorDTO;

import java.util.List;

public interface FormaDeNotificar {
  void notificar(DatoDeContacto datoDeContacto, String contenido, SuscriptorDTO suscriptorDTO);
}
