package info.snakea;

import info.snakea.artefacts.Person;
import info.snakea.artefacts.TeamInfo;
import info.snakea.artefacts.attributes.Seniority;
import info.snakea.utils.ReaderUtil;
import info.snakea.utils.SummaryTablesUtil;
import info.snakea.utils.WriteUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {

    public static void main(String[] args) {
        List<TeamInfo> teams = ReaderUtil.readDataFiles(Config.REGISTRATIONS_PATH);
        List<Person> guests = ReaderUtil.readDataFilesForGuests(Config.REGISTRATIONS_PATH);

        checkAgeValidity(teams);

        List<TeamInfo> seniors = teams.stream().filter(e -> e.getSeniority() == Seniority.SENIOR).collect(Collectors.toList());
        List<TeamInfo> juniors = teams.stream().filter(e -> e.getSeniority() == Seniority.JUNIOR).collect(Collectors.toList());

        sortTeams(seniors);
        sortTeams(juniors);

        WriteUtil.generateHTML(seniors, Config.SENIORS_HTML_FILE_BG, Config.SENIORS_HTML_FILE_EN);
        WriteUtil.generateHTML(juniors, Config.JUNIORS_HTML_FILE_BG, Config.JUNIORS_HTML_FILE_EN);

        SummaryTablesUtil.generateStatistics(juniors, seniors, teams, guests);
        SummaryTablesUtil.generateLeadersTable(teams, guests);
        SummaryTablesUtil.generateTeamsTable(teams);
        SummaryTablesUtil.generateContestantsTable(juniors, Config.JUNIORS_FILE);
        SummaryTablesUtil.generateContestantsTable(seniors, Config.SENIORS_FILE);
    }

    private static void checkAgeValidity(List<TeamInfo> teams) {
        // TODO fix date of birth format in tables
        //teams.forEach(t -> t.getContestants().forEach(c -> { System.out.println(c.getDateOfBirth()); }));
    }

    private static void sortTeams(List<TeamInfo> teams) {
        teams.sort(Comparator.comparing(TeamInfo::getCountry).thenComparing(TeamInfo::getEnTeamName));
        for (TeamInfo team : teams) {
            team.getContestants().sort(Comparator.comparing(Person::getEnName));
        }
    }
}