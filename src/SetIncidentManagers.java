import javax.swing.*;

public class SetIncidentManagers {

    public static void eventResponsible(Incidence incidence) {
        Person responsible = new Person();
        int response = JOptionPane.showConfirmDialog(
                null,
                "¿Desea introducir al responsable de la incidencia?",
                "RESPONSABLE DE LA INCIDENCIA",
                JOptionPane.YES_NO_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {

            String responsibleName;
            responsibleName = JOptionPane.showInputDialog(
                    null,
                    "Nombre del responsable",
                    "RESPONSABLE DE LA INCIDENCIA",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (responsibleName != null && !responsibleName.isEmpty()) {
                responsible.setFirstname(responsibleName);
            }

            String responsibleLastnames = JOptionPane.showInputDialog(
                    null,
                    "Apellidos del responsable",
                    "RESPONSABLE DE LA INCIDENCIA",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (responsibleLastnames != null && !responsibleLastnames.isEmpty()) {
                responsible.setLastnames(responsibleLastnames);
            }

            String responsibleEmail = JOptionPane.showInputDialog(
                    null,
                    "Correo electrónico del responsable",
                    "RESPONSABLE DE LA INCIDENCIA",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (responsibleEmail != null && !responsibleEmail.isEmpty()) {
                responsible.setEmail(responsibleEmail);
            }

            String responsibleNumberStr = JOptionPane.showInputDialog(
                    null,
                    "Número de teléfono del responsable",
                    "RESPONSABLE DE LA INCIDENCIA",
                    JOptionPane.INFORMATION_MESSAGE
            );

            do {
                if (responsibleNumberStr != null && !responsibleNumberStr.isEmpty()) {
                    try {
                        int responsibleNumber = Integer.parseInt(responsibleNumberStr);
                        responsible.setNumber(responsibleNumber);
                    } catch (NumberFormatException e) {
                        System.err.println("El número de teléfono no puede ser convertido a entero: " + e);
                        responsibleNumberStr = JOptionPane.showInputDialog(
                                null,
                                "El número de teléfono introducido contiene algún caracter no válido. Por favor, ingrese otro teléfono o cancelar para saltárselo",
                                "RESPONSABLE DE LA INCIDENCIA",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            } while (responsibleNumberStr == null);
        }
        incidence.setResponsible(responsible);
    }

    public static void eventSupervisors(Incidence incidence) {

        int response = JOptionPane.showConfirmDialog(
                null,
                "¿Desea introducir algún supervisor a la incidencia?",
                "SUPERVISORES DE LA INCIDENCIA",
                JOptionPane.YES_NO_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(
                    null,
                    "A continuación podrá ingresar supervisores A la incidencia (máximo 5)"
            );

            int more;
            int supervisorsCounter = 0;
            Person[] supervisors = new Person[5];

            String supervisorName;

            do {
                Person supervisor = new Person();
                supervisorName = JOptionPane.showInputDialog(
                        null,
                        "Nombre del supervisor",
                        "SUPERVISOR DE LA INCIDENCIA",
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (supervisorName != null && !supervisorName.isEmpty()) {
                    supervisor.setFirstname(supervisorName);
                }

                String supervisorLastnames = JOptionPane.showInputDialog(
                        null,
                        "Apellidos del supervisor",
                        "SUPERVISOR DE LA INCIDENCIA",
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (supervisorLastnames != null && !supervisorLastnames.isEmpty()) {
                    supervisor.setLastnames(supervisorLastnames);
                }

                String supervisorEmail = JOptionPane.showInputDialog(
                        null,
                        "Correo electrónico del supervisor",
                        "SUPERVISOR DE LA INCIDENCIA",
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (supervisorEmail != null && !supervisorEmail.isEmpty()) {
                    supervisor.setEmail(supervisorEmail);
                }

                String supervisorNumberStr = JOptionPane.showInputDialog(
                        null,
                        "Número de teléfono del supervisor",
                        "SUPERVISOR DE LA INCIDENCIA",
                        JOptionPane.INFORMATION_MESSAGE
                );

                do {
                    if (supervisorNumberStr != null && !supervisorNumberStr.isEmpty()) {
                        try {
                            int responsibleNumber = Integer.parseInt(supervisorNumberStr);
                            supervisor.setNumber(responsibleNumber);
                        } catch (NumberFormatException e) {
                            System.err.println("El número de teléfono no puede ser convertido a entero: " + e);
                            supervisorNumberStr = JOptionPane.showInputDialog(
                                    null,
                                    "El número de teléfono introducido contiene algún caracter no válido. Por favor, ingrese otro teléfono o cancelar para saltárselo",
                                    "SUPERVISOR DE LA INCIDENCIA",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                } while (supervisorNumberStr == null);

                supervisors[supervisorsCounter++] = supervisor;

                more = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea añadir algún supervisor más?",
                        "SUPERVISOR DE LA INCIDENCIA",
                        JOptionPane.YES_NO_OPTION
                );

            } while (more == JOptionPane.YES_OPTION && supervisorsCounter < 5);
            incidence.setSupervisor(supervisors);
        }
    }

}
