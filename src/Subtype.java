public enum Subtype {
    // Waters subtypes:

    STORMWATER("Aguas pluviales", MainType.WATERS),
    WASTEWATER("Aguas residuales", MainType.WATERS),

    // Public road subtypes:

    ROAD("Carretera", MainType.PUBLIC_ROADS),
    TRAIL("Camino", MainType.PUBLIC_ROADS),
    SIDEWALK("Acera", MainType.PUBLIC_ROADS),
    RURAL_ROAD("Vial Rural", MainType.PUBLIC_ROADS),
    WALL("Muro", MainType.PUBLIC_ROADS),

    // Public building subtypes:

    GENERAL_FACILITY("Dependencia en general", MainType.PUBLIC_BUILDING),
    SOCIAL_HALL("Local social", MainType.PUBLIC_BUILDING),
    LIBRARY("Biblioteca", MainType.PUBLIC_BUILDING),
    OFFICES("Oficinas", MainType.PUBLIC_BUILDING),
    MEDICAL_CENTER("Centro de salud", MainType.PUBLIC_BUILDING);

    private final String subtype;
    private final MainType mainType;

    Subtype(String subtype, MainType mainType) {
        this.subtype = subtype;
        this.mainType = mainType;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public MainType getMainType() {
        return this.mainType;
    }
}