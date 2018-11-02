package info.snakea.artefacts;

import info.snakea.Config;
import info.snakea.artefacts.attributes.Country;

import java.util.List;
import java.util.stream.Collectors;

public class TeamInfo {
    private static final String SEPARATOR = ", ";

    private Country nationality;

    private String enTeamName;
    private String bgTeamName;

    private Person leader;

    private Person depLeader;

    private List<Person> contestants;

    public Country getCountry() {
        return nationality;
    }

    public void setCountry(Country country) {
        this.nationality = country;
    }

    public String getEnTeamName() {
        String name = Config.enTeamNames.get(enTeamName);
        return name == null ? enTeamName : name;
    }

    public void setEnTeamName(String enTeamName) {
        this.enTeamName = enTeamName;
    }

    public String getBgTeamName() {
        String name = Config.bgTeamNames.get(enTeamName);
        return name == null ? bgTeamName : name;
    }

    public void setBgTeamName(String bgTeamName) {
        this.bgTeamName = bgTeamName;
    }

    public Person getLeader() {
        return leader;
    }

    public void setLeader(Person leader) {
        this.leader = leader;
    }

    public Person getDepLeader() {
        return depLeader;
    }

    public void setDepLeader(Person depLeader) {
        this.depLeader = depLeader;
    }

    public List<Person> getContestants() {
        return contestants;
    }

    public void setContestants(List<Person> contestants) {
        this.contestants = contestants;
    }

    @Override
    public String toString() {
        return String.valueOf(getCountry()) + "\n" +
               getEnTeamName() + "\n" +
               getLeader().getEnName() + "\n" +
               getDepLeader().getEnName() + "\n" +
               getContestants().stream().map(Person::getEnName).collect(Collectors.joining(SEPARATOR)) + "\n";
    }
}
