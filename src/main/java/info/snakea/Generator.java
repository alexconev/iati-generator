package info.snakea;

import info.snakea.artefacts.Person;
import info.snakea.artefacts.TeamInfo;
import info.snakea.utils.ReaderUtil;
import info.snakea.utils.SummaryTablesUtil;
import info.snakea.utils.WriteUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Generator {

    public static void main(String[] args) {
        List<TeamInfo> juniors = new ReaderUtil().readData(Config.SOURCE_PATH_JUNIORS, Config.SKIP_LINES);
        sortTeams(juniors);
        WriteUtil.generateHTML(juniors, Config.JUNIORS_HTML_FILE_BG, Config.JUNIORS_HTML_FILE_EN);

        List<TeamInfo> seniors = new ReaderUtil().readData(Config.SOURCE_PATH_SENIORS, Config.SKIP_LINES);
        sortTeams(seniors);
        WriteUtil.generateHTML(seniors, Config.SENIORS_HTML_FILE_BG, Config.SENIORS_HTML_FILE_EN);

        List<TeamInfo> teams = new ArrayList<>();
        teams.addAll(juniors);
        teams.addAll(seniors);

        SummaryTablesUtil.generateStatistics(juniors, seniors, teams);
        SummaryTablesUtil.generateLeadersTable(teams);
    }

    private static void sortTeams(List<TeamInfo> teams) {
        teams.sort(Comparator.comparing(TeamInfo::getCountry).thenComparing(TeamInfo::getEnTeamName));
        for (TeamInfo team : teams) {
            team.getContestants().sort(Comparator.comparing(Person::getEnName));
        }
    }
}