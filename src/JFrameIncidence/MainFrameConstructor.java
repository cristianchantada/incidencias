package JFrameIncidence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameConstructor extends JFrame implements ActionListener {

    // Incidence panel creation:
    JPanel jpanel = new JPanel();

    // Panel Sections:

    JLabel summaryLabel = new JLabel("Resumen");
    JTextField summaryText = new JTextField();

    JLabel notificationDateLabel = new JLabel("Fecha de notificación");
    JTextField notificationDateText = new JTextField();

    JLabel detectionDateLabel = new JLabel("Fecha de detección");
    JLabel placeLabel = new JLabel("Lugar");

    JLabel coordinatesLabel = new JLabel("Coordenadas");
    JLabel latitudeLabel = new JLabel("Latitud");
    JLabel longitudeLabel = new JLabel("Longitud");

    JLabel photoQuestionLabel = new JLabel("¿Desea incorporar fotografía?");

    JLabel incidenceDescriptionLabel = new JLabel("Descripción de la incidencia");

    JLabel responsibleLabel = new JLabel("Responsable de la incidencia");
    JLabel nameLabel = new JLabel("Nombre");
    JLabel lastNameLabel = new JLabel("Apellidos");
    JLabel emailLabel = new JLabel("Correo electrónico");
    JLabel phoneLabel = new JLabel("Número de teléfono");





    public void windowBuilder(){
        setSize(900,900);
        setTitle("Bingooooooooo !!!");
        setResizable(true);
        setLocation(250, 15);

        // Disposición nula para control total de panel
        jpanel.setLayout(null);

        jpanel.setBackground(Color.decode("#FFC482"));

        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
