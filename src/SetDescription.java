import javax.swing.*;

public class SetDescription {

    public static void eventDescription(Incidence incidence){
        String description = JOptionPane.showInputDialog(null,
                "Introduzca la descripción de la incidencia",
                "Descripción incidencia",
                JOptionPane.INFORMATION_MESSAGE
        );

        if(description != null){
            incidence.setDescription(description);
        }
    }
}
