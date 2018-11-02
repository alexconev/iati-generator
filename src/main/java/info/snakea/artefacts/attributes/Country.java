package info.snakea.artefacts.attributes;

import info.snakea.utils.StringUtil;

public enum Country {
    AR("http://iati-shu.org/wp-content/uploads/2018/10/armenia.jpg", "Armenia", "Армения"),
    AZ("http://iati-shu.org/wp-content/uploads/2018/10/azerbaijan.jpg", "Azerbaijan", "Азербайджан"),
    BG("http://iati2017.iati-shu.org/wp-content/uploads/2017/11/bulgaria.jpg", "Bulgaria", "България"),
    GR("http://iati2017.iati-shu.org/wp-content/uploads/2017/11/greece.jpg", "Greece", "Гърция"),
    MD("http://iati-shu.org/wp-content/uploads/2018/10/moldova.jpg", "Moldova", "Молдова"),
    PL("http://iati2017.iati-shu.org/wp-content/uploads/2017/11/poland.jpg", "Poland", "Полша"),
    RO("http://iati2017.iati-shu.org/wp-content/uploads/2017/11/rompng.png", "Romania", "Румъния"),
    RU("http://iati2017.iati-shu.org/wp-content/uploads/2017/11/russia.jpg", "Russia", "Русия"),
    SRB("http://iati2017.iati-shu.org/wp-content/uploads/2017/11/serbia.jpg", "Serbia", "Сърбия"),
    CH("http://iati-shu.org/wp-content/uploads/2018/10/switzerland.jpg", "Switzerland", "Швейцария"),
    UA("http://iati2017.iati-shu.org/wp-content/uploads/2017/11/ukraine.jpg", "Ukraine", "Украйна"),
    NONE("NaN", "none", "none");

    private String flagURL;
    private String enName;
    private String bgName;

    Country(String flagURL, String countryEnName, String countryBgName) {
        this.flagURL = flagURL;
        this.enName = countryEnName;
        this.bgName = countryBgName;
    }

    public String getFlagURL() {
        return flagURL;
    }

    public String getEnName() {
        return enName;
    }

    public String getBgName() {
        return bgName;
    }

    public static Country getCountry(String countryName) {
        for (Country item : Country.values()) {
            if (StringUtil.containsIgnoreCase(countryName.replace(" ", ""), item.enName)) {
                return item;
            }
        }

        return Country.NONE;
    }
}
