import javax.swing.*;

public class SetNotificationTasks {

    public static void incidentNotifications (Incidence incidence){

        int response = JOptionPane.showConfirmDialog(
                null,
                "¿Desea introducir tareas de notificación a la incidencia?",
                "TAREAS DE NOTIFICACIÓN",
                JOptionPane.YES_NO_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {

            String[] notificationsList = new String[10];
            String notification;
            int notificationsCounter = 0;
            JOptionPane.showMessageDialog(
                    null,
                    "A continuación podrá establecer tareas de notificación a la incidencia (máximo 10)"
            );

            do {

                notification = JOptionPane.showInputDialog(
                        null,
                        "Ingrese una notificación o cancelar para salir",
                        "NOTIFICACIÓN",
                        JOptionPane.INFORMATION_MESSAGE
                );

                notificationsList[notificationsCounter++] = notification;

            } while (notification != null && notificationsCounter < 10);
            incidence.setNotificationTask(notificationsList);
        }
    }

}
