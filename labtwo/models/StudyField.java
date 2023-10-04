package labtwo.models;

public enum StudyField {
    MECHANICAL_ENGINEERING, 
    SOFTWARE_ENGINEERING, 
    FOOD_TECHNOLOGY, 
    URBANISM_ARCHITECTURE,
    VETERINARY_MEDICINE;

    private String name;
    private String abbreviation;

    public String getName(){
        return name;
    }

    public String getAbbreviation(){
        return abbreviation;
    }

    public static StudyField findByAbbreviation(String abbreviationToCheck) {
        for (StudyField field : values()) {
            if (field.abbreviation.equals(abbreviationToCheck)) {
                return field;
            }
        }
        return null;
    }
}
