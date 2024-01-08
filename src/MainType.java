public enum MainType {
    LIGHTING("Iluminación"),
    WATERS("Aguas"),
    PUBLIC_ROADS("Vías públicas"),
    PUBLIC_BUILDING("Edificio público");

    private final String type;

    MainType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
