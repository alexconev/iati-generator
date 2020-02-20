package info.snakea.artefacts;

import info.snakea.artefacts.attributes.OS;
import info.snakea.artefacts.attributes.ShirtSize;

import info.snakea.utils.StringUtil;

public class Person implements Comparable<Person> {
    private String enFirstName;
    private String enLastName;

    private String bgFirstName;
    private String bgLastName;

    private ShirtSize shirtSize;
    private OS operatingSystem;

    private String dateOfBirth;

    private String country;

    private static final String CLEANUP_STRING = "\\p{C}";

    public Person() {
        enFirstName = "";
        enLastName = "";
        bgFirstName = "";
        bgLastName = "";
    }

    public Person(String enFirstName, String enLastName) {
        this.bgFirstName = this.enFirstName = enFirstName.replaceAll(CLEANUP_STRING, "").trim();
        this.bgLastName = this.enLastName = enLastName.replaceAll(CLEANUP_STRING, "").trim();
    }

    public Person(String enFirstName, String enLastName, String bgFirstName, String bgLastName) {
        this.enFirstName = enFirstName.replaceAll(CLEANUP_STRING, "").trim();
        this.enLastName = enLastName.replaceAll(CLEANUP_STRING, "").trim();

        this.bgFirstName = bgFirstName.replaceAll(CLEANUP_STRING, "").trim();
        this.bgLastName = bgLastName.replaceAll(CLEANUP_STRING, "").trim();
    }

    public String getBgName() {
        return StringUtil.toDisplayCase(bgFirstName + " " + bgLastName);
    }

    public String getEnName() {
        return StringUtil.toDisplayCase(enFirstName + " " + enLastName);
    }

    public ShirtSize getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(ShirtSize shirtSize) {
        this.shirtSize = shirtSize;
    }

    public OS getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OS operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Boolean hasEmptyName() {
        return enFirstName.isEmpty() || enLastName.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }

        Person o = (Person) obj;

        return getEnName().equals(o.getEnName());
    }

    @Override
    public int hashCode() {
        return getEnName().hashCode();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int compareTo(Person o) {
        return this.getEnName().compareTo(o.getEnName());
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
