import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        /**
         * Configuration variables:
         *
         *  ABSOLUTE_PATH_TO_SRC -> Insert the absolute path to the directory of your project where your
         * database writing file is located. Example: C:\\example\\myProject\\src\\model
         *
         * DATA_BASE_FILE_NAME -> Insert the database file name. Example: example.txt
         *
         * ABSOLUTE_PATH_TO_VIEW_DIR -> Insert the absolute path to the directory of your project where
         * your HTML file is located. Example: C:\\example\\myProject\\src\\view
         *
         * HTML_FILE_NAME -> Insert the HTML file name. Example: index.html
         */


        final String ABSOLUTE_PATH_TO_MODEL_DIR = "C:\\Users\\Usuario\\IdeaProjects\\incidencias\\src\\model";
        final String DATA_BASE_FILE_NAME = "incidencesDB.txt";

        final String ABSOLUTE_PATH_TO_VIEW_DIR = "C:\\Users\\Usuario\\IdeaProjects\\incidencias\\src\\view";
        final String HTML_FILE_NAME = "index.html";

        final String PATH_TO_DB_FILE = ABSOLUTE_PATH_TO_MODEL_DIR + "\\" + DATA_BASE_FILE_NAME;
        final String PATH_TO_HTML_FILE = ABSOLUTE_PATH_TO_VIEW_DIR + "\\" + HTML_FILE_NAME;

        int optionTypeIndex = 0;

        do {
            Incidence incidence = new Incidence();
            // Access to the class that establishes the types and subtypes of the event:
            optionTypeIndex = SetTypeAndSubtype.incidenceTypeSubtypes(incidence, optionTypeIndex);
            if(optionTypeIndex == 5){
                break;
            }

            System.out.println(incidence.getSubtype());

            // Insertion of a brief summary of the incident:
            SetSummary.eventSummary(incidence);

            // Methods of entering the dates of notification and detection of the incident:
            HappenedAt happenedAt = new HappenedAt();
            SetIncidenceDates.setNotificationDate(incidence, happenedAt);
            SetIncidenceDates.setDetectionDate(incidence, happenedAt);

            // Enter the data of the place where the incident occurred:
            SetEventLocation.setLocation(incidence);

            // Incident description:
            SetDescription.eventDescription(incidence);

            // Establishment of the person in charge and supervisor of the incident:
            SetIncidentManagers.eventResponsible(incidence);

            SetIncidentManagers.eventSupervisors(incidence);

            // Establishment of the incident notification tasks;
            SetNotificationTasks.incidentNotifications(incidence);

            // Writing the data of the incident instance in the database and in the .html file:
            BDWriter.write(incidence, PATH_TO_DB_FILE, PATH_TO_HTML_FILE);

        } while (optionTypeIndex != 5) ;
        JOptionPane.showMessageDialog(null, "Has salido con éxito");
    }
}
