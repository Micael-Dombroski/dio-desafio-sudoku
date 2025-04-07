package model;

public enum GamesStatusEnum {
    NON_STARTED("Não iniciado"),
    INCOMPLETE("Incompleto"),
    COMPLETE("Completo");

    private String label;

    GamesStatusEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
