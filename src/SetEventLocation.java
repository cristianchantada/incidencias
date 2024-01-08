
import javax.swing.*;

public class SetEventLocation {

    public static void setLocation (Incidence incidence){
        GeoCoordinates geoCoordinates = new GeoCoordinates();
        EventLocation eventLocation = new EventLocation();
        String location = JOptionPane.showInputDialog(null,
                "¿Dón ha ocurrido la incidencia?",
                "Localización de la incidencia",
                JOptionPane.QUESTION_MESSAGE
        );

        if(location != null && !location.isEmpty()){
            eventLocation.setEventLocation(location);
        }

        double longitude = 0.00, latitude = 0.00;
        int response = JOptionPane.showConfirmDialog(
                null,
                "¿Desea introducir las coordenadas geoespaciales de la incidencia ?",
                "Coordenadas geoespaciales",
                JOptionPane.YES_NO_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {
            String latitudeStr = JOptionPane.showInputDialog(null,
                    "Introduzca la latitud en formato válido (nn.nnnnnn)",
                    "LATITUD DE LA INCIDENCIA",
                    JOptionPane.QUESTION_MESSAGE
            );

            do {
                if(latitudeStr != null && !latitudeStr.isEmpty()) {
                    try {
                        latitude = Double.parseDouble(latitudeStr);
                        geoCoordinates.setLatitude(latitude);
                    } catch (NumberFormatException e) {
                        System.err.println("Ha ocurrido un error en el formateo de la latitud : " + e);

                        latitudeStr = JOptionPane.showInputDialog(
                                null,
                                "La latitud contiene algún caracter no válido. Por favor, inserte otra latitud o cancelar para saltársela",
                                "RESPONSABLE DE LA INCIDENCIA",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            } while(latitudeStr == null);
            String longitudeStr = JOptionPane.showInputDialog(null,
                    "Introduzca la longitud en formato válido (nn.nnnnnn)",
                    "LONGITUD DE LA INCIDENCIA",
                    JOptionPane.QUESTION_MESSAGE
            );

            do {
                if(longitudeStr != null && !longitudeStr.isEmpty()) {
                    try {
                        longitude = Double.parseDouble(longitudeStr);
                        geoCoordinates.setLongitude(longitude);
                    } catch (NumberFormatException e) {
                        System.err.println("Ha ocurrido un error en el formateo de la longitud : " + e);

                        longitudeStr = JOptionPane.showInputDialog(
                                null,
                                "La longitud contiene algún caracter no válido. Por favor, inserte otra longitud o cancelar para saltársela",
                                "RESPONSABLE DE LA INCIDENCIA",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            } while(longitudeStr == null);
        }

        eventLocation.setCoordinates(geoCoordinates);

        response = JOptionPane.showConfirmDialog(
                null,
                "¿Quiere adjuntar fotografía?",
                "Fotografía",
                JOptionPane.YES_NO_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {
            String photoAbsolutePath = JOptionPane.showInputDialog(null,
                    "Introduzca la RUTA absoluta, incluyendo el nombre de la fotografía",
                    "RUTA ABSOLUTA A FOTOGRAFÏA",
                    JOptionPane.QUESTION_MESSAGE
            );
            eventLocation.setEventPhoto(photoAbsolutePath);
        }

        incidence.setWhere(eventLocation);

    }

}
