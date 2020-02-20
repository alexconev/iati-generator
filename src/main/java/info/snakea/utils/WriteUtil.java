package info.snakea.utils;

import info.snakea.artefacts.Person;
import info.snakea.artefacts.TeamInfo;
import info.snakea.Config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteUtil {

    private static final String OPEN_DIV_PERSON = "        <div class=\"contestant\" ";
    private static final String OPEN_IMG = "><img src=\"";
    private static final String ALT = "\" alt=\"";
    private static final String ATTRIBUTES = "\" width=\"100\" height=\"100\" class=\"size-medium\" /><br/><a>";
    private static final String A_BR = "</a><br/><span>";
    private static final String CLOSE_DIV = "</span></div>\n";

    private WriteUtil() {
        super();
    }

    public static void generateHTML(List<TeamInfo> teams, String bgHtmlFile, String enHtmlFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bgHtmlFile))) {
            for (TeamInfo team : teams) {
                bw.write(getTeamsBgHtml(team));
            }
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(enHtmlFile))) {
            for (TeamInfo team : teams) {
                writer.write(getTeamsEnHtml(team));
            }
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }
    }

    private static String getTeamsBgHtml(TeamInfo team) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n<div class=\"participants\">\n");
        sb.append("    <div class=\"head\"><img src=\"").append(team.getCountry().getFlagURL()).append("\" alt=\"\" width=\"53\" height=\"35\" class=\"alignnone size-full wp-image-620\" /><span>").append(team.getCountry().getBgName()).append(" (").append(team.getBgTeamName()).append(")</span><i class=\"fa fa-chevron-circle-down\"></i></div>\n");
        sb.append("    <div class=\"body\">\n");

        String contestantStyle = getContestantStyle(team);

        if (team.getLeader() != null && !team.getLeader().hasEmptyName()) {
            sb.append(getPersonImageHtml(team.getLeader().getBgName(), team.getLeader().getEnName(), Config.TL_BG_TITLE, contestantStyle));
        }

        if (team.getDepLeader() != null && !team.getDepLeader().hasEmptyName()) {
            sb.append(getPersonImageHtml(team.getDepLeader().getBgName(), team.getDepLeader().getEnName(), Config.DEPTL_BG_TITLE, contestantStyle));
        }

        for (Person contestant : team.getContestants()) {
            if (!contestant.hasEmptyName()) {
                sb.append(getPersonImageHtml(contestant.getBgName(), contestant.getEnName(), Config.CONTESTANT_BG_TITLE, contestantStyle));
            }
        }

        sb.append("        <div class=\"clear\"></div>\n    </div>\n");
        sb.append("</div><br/>");

        return sb.toString();
    }

    private static String getTeamsEnHtml(TeamInfo team) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n<div class=\"participants\">\n");
        sb.append("    <div class=\"head\"><img src=\"")
                .append(team.getCountry().getFlagURL())
                .append("\" alt=\"\" width=\"53\" height=\"35\" class=\"alignnone size-full wp-image-620\" /><span>")
                .append(team.getCountry().getEnName())
                .append(" (").append(team.getEnTeamName())
                .append(")</span><i class=\"fa fa-chevron-circle-down\"></i></div>\n");
        sb.append("    <div class=\"body\">\n");

        String contestantStyle = getContestantStyle(team);

        if (team.getLeader() != null && !team.getLeader().hasEmptyName()) {
            sb.append(getPersonImageHtml(team.getLeader().getEnName(), team.getLeader().getEnName(), Config.TL_EN_TITLE, contestantStyle));
        }

        if (team.getDepLeader() != null && !team.getDepLeader().hasEmptyName()) {
            sb.append(getPersonImageHtml(team.getDepLeader().getEnName(), team.getDepLeader().getEnName(), Config.DEPTL_EN_TITLE, contestantStyle));
        }

        for (Person contestant : team.getContestants()) {
            if (!contestant.hasEmptyName()) {
                sb.append(getPersonImageHtml(contestant.getEnName(), contestant.getEnName(), Config.CONTESTANT_EN_TITLE, contestantStyle));
            }
        }

        sb.append("        <div class=\"clear\"></div>\n    </div>\n");
        sb.append("</div><br/>");

        return sb.toString();
    }

    private static String getPersonImageHtml(String contestantName, String contestantKey, String contestantTitle, String contestantStyle) {
        StringBuilder sb = new StringBuilder();
        sb.append(OPEN_DIV_PERSON)
                .append(contestantStyle)
                .append(OPEN_IMG)
                .append(getImagePath(contestantKey))
                .append(ALT)
                .append(contestantName)
                .append(ATTRIBUTES)
                .append(contestantName)
                .append(A_BR)
                .append(contestantTitle)
                .append(CLOSE_DIV);

        return sb.toString();
    }

    private static String getContestantStyle(TeamInfo team) {
        int people = 0;
        if (team.getLeader() != null && !team.getLeader().hasEmptyName()) {
            people++;
        }
        if (team.getDepLeader() != null && !team.getDepLeader().hasEmptyName()) {
            people++;
        }
        people += team.getContestants().size();

        if (people == 7) return "style=\"width: 12%;\"";
        else return "";
    }

    private static String getImagePath(String name) {
        String imagePath = Config.participantImages.get(name);

        if (imagePath == null) {
            String imageName =  name.replace(' ', '_') + ".jpg";
            File f = new File(Config.IMAGES_PATH + imageName);
            if(f.exists() && !f.isDirectory()) {
                return Config.PATH_TO_IMAGES + imageName;
            }
        }

        if (imagePath == null) {
            System.out.println("Missing image for: " + name);
            return Config.NO_IMAGE;
        } else {
            return Config.PATH_TO_IMAGES + imagePath;
        }
    }

    public static void printParticipantImagesMapKeys(TeamInfo team) {
        final String MAP_PUT = " participantImages.put(\"";
        final String MAP_CLOSE = "\", \"\");";

        if (!team.getLeader().hasEmptyName() && !Config.participantImages.containsKey(team.getLeader().getEnName())) {
            System.out.println(team.getCountry() + MAP_PUT + team.getLeader().getEnName() + MAP_CLOSE);
        }

        if (!team.getDepLeader().hasEmptyName() && !Config.participantImages.containsKey(team.getDepLeader().getEnName())) {
            System.out.println(team.getCountry() + MAP_PUT + team.getDepLeader().getEnName() + MAP_CLOSE);
        }

        for (Person contestant : team.getContestants()) {
            if (!Config.participantImages.containsKey(contestant.getEnName())) {
                System.out.println(team.getCountry() + MAP_PUT + contestant + MAP_CLOSE);
            }
        }
    }
}