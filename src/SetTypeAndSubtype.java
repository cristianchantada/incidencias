import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class SetTypeAndSubtype {


    // Incidence main type selector:
    JLabel incidenceMainTypeLabel = new JLabel("Seleccione el tipo de incidencia");
    JComboBox incidenceMainTypeSelector = new JComboBox();

    // Incidence subtype selector:
    JLabel incidenceSubtypeLabel = new JLabel("Seleccione el subtipo de la incidencia");

    public static int incidenceTypeSubtypes (Incidence incidence, int optionTypeIndex){
        Map<String, Integer> typeOptionPanel = new HashMap<>();
        typeOptionPanel.put("Iluminación", 1);
        typeOptionPanel.put("Aguas", 2);
        typeOptionPanel.put("Vías públicas", 3);
        typeOptionPanel.put("Edificio público", 4);
        typeOptionPanel.put("SALIR DEL PROGRAMA", 5);

        // The keys of the typeOptionPanel are transformed to array so that they can be displayed
        // in the JOptionPane.showInputDialog:

        Object[] optionArray = typeOptionPanel.keySet().toArray();

        Object option = JOptionPane.showInputDialog(
                null,
                "Seleccione el TIPO PRINCIPAL de la incidencia",
                "TIPO DE INCIDENCIA",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                optionArray,
                optionArray[0]
        );

        if (option == null) {
            JOptionPane.showMessageDialog(null, "Programa finalizado");
            System.exit(0);
        } else {
            optionTypeIndex = typeOptionPanel.get(option.toString());

            //creation of the HashMap for the subtypes of the incident:
            int optionSubtypeIndex = 0;
            Map<String, Integer> subtypeOptionPanel = new HashMap<>();

            switch (optionTypeIndex) {
                case 1:
                    incidence.setType(MainType.LIGHTING);
                    break;
                case 2:
                    incidence.setType(MainType.WATERS);

                    subtypeOptionPanel.put("Aguas pluviales", 1);
                    subtypeOptionPanel.put("Aguas residuales", 2);

                    optionArray = subtypeOptionPanel.keySet().toArray();
                    option = JOptionPane.showInputDialog(
                            null,
                            "Seleccione el SUBTIPO de la incidencia",
                            "SUBTIPO DE LA INCIDENCIA",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            optionArray,
                            optionArray[0]
                    );

                    if(option != null){
                        optionSubtypeIndex = subtypeOptionPanel.get(option.toString());
                    }

                    switch (optionSubtypeIndex) {
                        case 1:
                            incidence.setSubtype(Subtype.STORMWATER);
                            break;
                        case 2:
                            incidence.setSubtype(Subtype.WASTEWATER);
                            break;
                    }
                    break;
                case 3:
                    incidence.setType(MainType.PUBLIC_ROADS);

                    subtypeOptionPanel.put("Carretera", 1);
                    subtypeOptionPanel.put("Camino", 2);
                    subtypeOptionPanel.put("Acera", 3);
                    subtypeOptionPanel.put("Vial Rural", 4);
                    subtypeOptionPanel.put("Muro", 5);

                    optionArray = subtypeOptionPanel.keySet().toArray();
                    option = JOptionPane.showInputDialog(
                            null,
                            "Seleccione el SUBTIPO de la incidencia",
                            "SUBTIPO DE LA INCIDENCIA",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            optionArray,
                            optionArray[0]
                    );

                    if(option != null){
                        optionSubtypeIndex = subtypeOptionPanel.get(option.toString());
                    }

                    switch (optionSubtypeIndex) {
                        case 1:
                            incidence.setSubtype(Subtype.ROAD);
                            break;
                        case 2:
                            incidence.setSubtype(Subtype.TRAIL);
                            break;
                        case 3:
                            incidence.setSubtype(Subtype.SIDEWALK);
                            break;
                        case 4:
                            incidence.setSubtype(Subtype.RURAL_ROAD);
                            break;
                        case 5:
                            incidence.setSubtype(Subtype.WALL);
                            break;
                    }
                    break;
                case 4:
                    incidence.setType(MainType.PUBLIC_BUILDING);

                    subtypeOptionPanel.put("Dependencia en general", 1);
                    subtypeOptionPanel.put("Local social", 2);
                    subtypeOptionPanel.put("Biblioteca", 3);
                    subtypeOptionPanel.put("Oficinas", 4);
                    subtypeOptionPanel.put("Centro de salud", 5);

                    optionArray = subtypeOptionPanel.keySet().toArray();
                    option = JOptionPane.showInputDialog(
                            null,
                            "Seleccione el SUBTIPO de la incidencia",
                            "SUBTIPO DE LA INCIDENCIA",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            optionArray,
                            optionArray[0]
                    );

                    if(option != null){
                        optionSubtypeIndex = subtypeOptionPanel.get(option.toString());
                    }

                    switch (optionSubtypeIndex) {
                        case 1:
                            incidence.setSubtype(Subtype.GENERAL_FACILITY);
                            break;
                        case 2:
                            incidence.setSubtype(Subtype.SOCIAL_HALL);
                            break;
                        case 3:
                            incidence.setSubtype(Subtype.LIBRARY);
                            break;
                        case 4:
                            incidence.setSubtype(Subtype.OFFICES);
                            break;
                        case 5:
                            incidence.setSubtype(Subtype.MEDICAL_CENTER);
                            break;
                    }
                    break;
                case 5:
                    optionTypeIndex = 5;
                    break;
            }
        }

        return optionTypeIndex;

    }
}
