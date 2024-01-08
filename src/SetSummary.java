import javax.swing.*;

public class SetSummary {

    public static void eventSummary(Incidence incidence) {

        String summary = JOptionPane.showInputDialog(
                null,
                "Introduzca resumen incidencia",
                "RESUMEN DE LA INCIDENCIA",
                JOptionPane.INFORMATION_MESSAGE
        );

        if (summary != null && !summary.isEmpty()){
            incidence.setSummary(summary);
        }

    }

}
