import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.*;

public class BDWriter {

    public static void write(Incidence incidence, String PATH_TO_DB_FILE, String PATH_TO_HTML_FILE){

        File BDfile = new File(PATH_TO_DB_FILE);
        File HTMLfile = new File(PATH_TO_HTML_FILE);

        final String JUMP = "\n", TAB = "\t", TABLE = JUMP + TAB + "<table>", CLOSE_TABLE = JUMP + TAB + "</table>" + JUMP,
                TR= JUMP + TAB.repeat(2) + "<tr>", CLOSE_TR= JUMP + TAB.repeat(2) + "</tr>",
                NOT_REPORTED= "--no consta--";

        try {
            Scanner BDfileReader = new Scanner(BDfile);
            Scanner HTMLfileReader = new Scanner(HTMLfile);

            // I abbreviate FileWriters to put them repeatedly in the twinsWriter() function:
            FileWriter a = new FileWriter(PATH_TO_DB_FILE, true);
            FileWriter b = new FileWriter(PATH_TO_HTML_FILE, true);

            a.write( "=========================================================================================================" + JUMP.repeat(2));
            b.write(TABLE);

            if(incidence.getSummary() != null){
                twinsWriter(("INDIDENCIA " + incidence.getId() + ": " + incidence.getSummary() + "." + JUMP), a, b);
            } else {
                twinsWriter(("INDIDENCIA " + incidence.getId() + ":" + JUMP ), a, b);
            }

            if(incidence.getSubtype() != null){
                twinsWriter((TAB + "- Tipo: " + incidence.getType().getType() + " (" + incidence.getSubtype().getSubtype() + ")." + JUMP), a, b);
            } else {
                twinsWriter((TAB + "- Tipo: " + incidence.getType().getType() + JUMP), a, b);
            }

            if(incidence.getWhen() != null && incidence.getWhen().getDateNotification() != null){
                long timeInMillis = incidence.getWhen().getDateNotification().getTime();
                Date date = new Date(timeInMillis);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = dateFormat.format(date);

                twinsWriter((TAB + "- Fecha de notificación: " + formattedDate + JUMP), a, b);
            } else {
                twinsWriter((TAB + "- Fecha de notificación: " + NOT_REPORTED + JUMP), a, b);
            }

            if(incidence.getWhen() != null && incidence.getWhen().getDateDetection() != null){

                long timeInMillis = incidence.getWhen().getDateDetection().getTime();
                Date date = new Date(timeInMillis);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = dateFormat.format(date);

                twinsWriter((TAB + "- Fecha de detección: " + formattedDate + JUMP.repeat(2)), a, b);
            } else {
                twinsWriter((TAB + "- Fecha de detección: " + NOT_REPORTED + JUMP.repeat(2)),a,b);
            }

            twinsWriter((TAB + "================ DATOS DEL LUGAR =============================" + JUMP.repeat(2)),a,b);

            if(incidence.getWhere().getEventLocation() != null){
                twinsWriter((TAB + "- Lugar: " + incidence.getWhere().getEventLocation() + "." + TAB),a,b);
            } else {
                twinsWriter((TAB + "- Lugar: " + NOT_REPORTED + TAB),a,b);
            }

            if(incidence.getWhere().getCoordinates().getLatitude() != 0 && incidence.getWhere().getCoordinates().getLongitude() != 0){
                twinsWriter(("- Coordenadas geográficas: latitud " + incidence.getWhere().getCoordinates().getLatitude() +
                        "; longitud " + incidence.getWhere().getCoordinates().getLongitude() + "." + JUMP
                ),a,b);
            } else {
                twinsWriter((JUMP), a, b);
            }

            if(incidence.getWhere().getEventPhoto() != null){
                twinsWriter((TAB + "- Ruta absoluta de la imagen en el sistema de archivos: " + incidence.getWhere().getEventPhoto() + "." + TAB + JUMP.repeat(2)),a,b);
                b.write("<tr>");
                b.write("<td><img src=\"" + incidence.getWhere().getEventPhoto() + "\" alt=\"foto de la incidencia\"></td>");
                b.write("</tr>");
            } else {
                twinsWriter((TAB + "- Ruta absoluta de la imagen en el sistema de archivos: " + NOT_REPORTED + TAB + JUMP.repeat(2)),a,b);
            }

            twinsWriter((TAB + "================ DESCRIPCIÓN DE LA INCIDENCIA ================" + JUMP.repeat(2)),a,b);

            if(incidence.getDescription() != null){
                twinsWriter((TAB + "- " + incidence.getDescription() + "." + JUMP.repeat(2)),a,b);
            } else {
                twinsWriter((TAB + NOT_REPORTED + JUMP.repeat(2)),a,b);
            }

            twinsWriter((TAB + "================ ENCARGADOS DE LA GESTIÓN ====================" + JUMP.repeat(2) +
                    TAB + "- RESPONSABLE:" + JUMP +
                    TAB.repeat(2)
            ),a,b);

            if(incidence.getResponsible().getName() != null && incidence.getResponsible().getLastnames() != null){
                twinsWriter((incidence.getResponsible().getName() + " " + incidence.getResponsible().getLastnames() + "." + JUMP),a,b);
            } else if (incidence.getResponsible().getName() != null && incidence.getResponsible().getLastnames() == null ) {
                twinsWriter((incidence.getResponsible().getName() + JUMP),a,b);
            } else if (incidence.getResponsible().getName() == null && incidence.getResponsible().getLastnames() != null ) {
                twinsWriter((incidence.getResponsible().getLastnames() + JUMP),a,b);
            } else {
                twinsWriter((NOT_REPORTED + JUMP),a,b);
            }

            if (incidence.getResponsible().getNumber() != 0 && incidence.getResponsible().getEmail() != null) {
                twinsWriter((TAB.repeat(2) + "- Teléfono: " + incidence.getResponsible().getNumber() + TAB + "- Correo electrónico: " + incidence.getResponsible().getEmail() + JUMP.repeat(2)), a, b);
            } else if (incidence.getResponsible().getNumber() != 0 && incidence.getResponsible().getEmail() == null) {
                twinsWriter((TAB.repeat(2) + "- Teléfono: " + incidence.getResponsible().getNumber() + TAB + "- Correo electrónico: " + NOT_REPORTED + JUMP.repeat(2)), a, b);
            } else if (incidence.getResponsible().getNumber() == 0 && incidence.getResponsible().getEmail() != null) {
                twinsWriter((TAB.repeat(2) + "- Teléfono: " + NOT_REPORTED + TAB + "- Correo electrónico: " + incidence.getResponsible().getEmail() + JUMP.repeat(2)), a, b);
            }

            twinsWriter((TAB + "- SUPERVISORES:" + JUMP),a,b);

            if(incidence.getSupervisor() != null && incidence.getSupervisor().length > 0){
                for(int i = 0; i < incidence.getSupervisor().length; i++){
                    if(incidence.getSupervisor()[i] != null) {
                        if (incidence.getSupervisor()[i].getName() != null && incidence.getSupervisor()[i].getLastnames() != null) {
                            twinsWriter((TAB.repeat(2) + (i+1) + "º.- " + incidence.getSupervisor()[i].getName() + " " + incidence.getSupervisor()[i].getLastnames() + " " + JUMP), a, b);
                        } else if (incidence.getSupervisor()[i].getName() != null && incidence.getSupervisor()[i].getLastnames() == null) {
                            twinsWriter((TAB.repeat(2) + (i+1) + "º.- " + incidence.getSupervisor()[i].getName() + JUMP), a, b);
                        } else if (incidence.getSupervisor()[i].getName() == null && incidence.getSupervisor()[i].getLastnames() != null) {
                            twinsWriter((TAB.repeat(2) + (i+1) + "º.- " + incidence.getSupervisor()[i].getLastnames() + JUMP), a, b);
                        } else {
                            twinsWriter((TAB.repeat(2) + NOT_REPORTED + JUMP), a, b);
                        }

                        if (incidence.getSupervisor()[i].getNumber() != 0 && incidence.getSupervisor()[i].getEmail() != null) {
                            twinsWriter((TAB.repeat(2) + "   - Teléfono: " + incidence.getSupervisor()[i].getNumber() + TAB + "- Correo electrónico: " + incidence.getSupervisor()[i].getEmail() + JUMP.repeat(2)), a, b);
                        } else if (incidence.getSupervisor()[i].getNumber() != 0 && incidence.getSupervisor()[i].getEmail() == null) {
                            twinsWriter((TAB.repeat(2) + "   - Teléfono: " + incidence.getSupervisor()[i].getNumber() + TAB + "- Correo electrónico: " + NOT_REPORTED + JUMP.repeat(2)), a, b);
                        } else if (incidence.getSupervisor()[i].getNumber() == 0 && incidence.getSupervisor()[i].getEmail() != null) {
                            twinsWriter((TAB.repeat(2) + "   - Teléfono: " + NOT_REPORTED + TAB + "- Correo electrónico: " + incidence.getSupervisor()[i].getEmail() + JUMP.repeat(2)), a, b);
                        }
                    }
                }
            } else {
                twinsWriter((TAB.repeat(2) + NOT_REPORTED + JUMP.repeat(2)),a,b);
            }

            twinsWriter((TAB + "================ TAREAS DE NOTIFICACIÓN ======================" + JUMP.repeat(2)),a,b);
            
            if(incidence.getNotificationTask() != null && incidence.getNotificationTask().length > 0){
                for(int i = 0; i < incidence.getNotificationTask().length; i++){
                    if(incidence.getNotificationTask()[i] != null) {
                        twinsWriter((TAB.repeat(2) + (i+1) + "ª.- " + incidence.getNotificationTask()[i] + "." + JUMP), a, b);
                    }
                }
            } else {
                twinsWriter((TAB.repeat(2) + NOT_REPORTED + JUMP),a,b);
            }

            a.write( JUMP + "=========================================================================================================" + JUMP);
            b.write(CLOSE_TABLE);

            a.close();
            BDfileReader.close();
            HTMLfileReader.close();
            b.close();

        } catch (Exception e){
            System.err.println("Ha habido un error de escritura en la base de datos: " + e);
            e.getStackTrace();
        }

    }

    public static void twinsWriter(String string, FileWriter a, FileWriter b){
            final String TAB = "\t", JUMP="\n", TR = JUMP + TAB.repeat(2) + "<tr>", CLOSE_TR = TAB.repeat(2) + "</tr>" + JUMP,
                    TD = JUMP + TAB.repeat(3) + "<td>", CLOSE_TD=TAB.repeat(3)+ "</td>" + JUMP;
        try {
            a.write(string);
            b.write(TR);
            b.write(TD + JUMP);
            b.write(TAB.repeat(4) + string);
            b.write(CLOSE_TD);
            b.write(CLOSE_TR);

        } catch (Exception e){
            System.err.println("Ha habido un error de escritura en el método twinsWriter de la clase BDWriter: " + e);
            e.getStackTrace();
        }
    }
}
