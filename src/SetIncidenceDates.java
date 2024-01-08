import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetIncidenceDates {

    public static void setNotificationDate(Incidence incidence, HappenedAt happenedAt){

        Date notificationDate = new Date();
        SimpleDateFormat notificationDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        int response = JOptionPane.showConfirmDialog(
                null,
                "¿Es ahora la fecha de notificación de la incidencia?",
                "FECHA DE NOTIFICACIÓN DE LA INCIDENCIA",
                JOptionPane.YES_NO_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {
            happenedAt.setDateNotification(notificationDate);
            incidence.setWhen(happenedAt);

        } else if (response == JOptionPane.NO_OPTION) {
            do {
                try {
                    String notificationDateStr = JOptionPane.showInputDialog(null,
                            "Introduce la fecha de notificación de la incidencia en (formato DD/MM/AAAA):",
                            "FECHA DE NOTIFICACIÓN DE LA INCIDENCIA",
                            JOptionPane.QUESTION_MESSAGE);

                    if (notificationDateStr == null) {
                        return;
                    }

                    notificationDate = notificationDateFormatter.parse(notificationDateStr);
                    happenedAt.setDateNotification(notificationDate);
                    incidence.setWhen(happenedAt);
                    break;
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha no válido. Por favor, introduce la fecha de notificación de la incidencia en formato DD/MM/AAAA.");
                }
            } while (true);
        }

        if (notificationDate != null) {
            JOptionPane.showMessageDialog(null, "La fecha de notificación introducida es: " +
                    notificationDateFormatter.format(notificationDate));
        }

    }

    public static void setDetectionDate(Incidence incidence, HappenedAt happenedAt){
        SimpleDateFormat detectionDateformatter = new SimpleDateFormat("dd/MM/yyyy");
        Date detectionDate = null;
        do {
            try {
                String detectionDateStr = JOptionPane.showInputDialog(null,
                        "Introduce la fecha de detección de la incidencia (formato DD/MM/AAAA):",
                        "FECHA DE DETECCIÓN DE LA INCIDENCIA",
                        JOptionPane.QUESTION_MESSAGE);

                if (detectionDateStr == null) {
                    return;
                }

                detectionDate = detectionDateformatter.parse(detectionDateStr);
                happenedAt.setDateDetection(detectionDate);

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha no válido. Por favor, introduce la fecha de deteción de la incidencia en formato DD/MM/AAAA.");
            }
        } while (detectionDate == null);
        incidence.setWhen(happenedAt);
        JOptionPane.showMessageDialog(null, "La fecha de detección introducida es: " + detectionDateformatter.format(detectionDate));
    }
}
