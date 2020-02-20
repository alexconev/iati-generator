package info.snakea.utils;

import info.snakea.Config;
import info.snakea.artefacts.attributes.Country;
import info.snakea.artefacts.attributes.OS;
import info.snakea.artefacts.Person;
import info.snakea.artefacts.TeamInfo;
import info.snakea.artefacts.attributes.ShirtSize;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static info.snakea.Config.STATISTICS_FILE;

public class SummaryTablesUtil {

    private SummaryTablesUtil() {
        super();
    }

    public static void generateLeadersTable(List<TeamInfo> teams, List<Person> guests) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Leaders");

        Map<Person, List<String>> countryLeads = new TreeMap<>();
        teams.forEach(e -> {
            List<String> tmp = new ArrayList<>();
            tmp.add(e.getCountry().getEnName());
            tmp.add(e.getEnTeamName());
            tmp.add("Leader");
            countryLeads.put(e.getLeader(), tmp);

            if (e.getDepLeader() != null && !countryLeads.containsKey(e.getDepLeader())) {
                tmp.add(2, "Deputy Leader");
                countryLeads.put(e.getDepLeader(), tmp);
            }
        });

        guests.forEach(e -> {
            List<String> tmp = new ArrayList<>();
            tmp.add(e.getCountry());
            tmp.add("");
            tmp.add("Guest");
            countryLeads.put(e, tmp);
//            if (!"Bulgaria".equals(e.getCountry())) {
//                countryLeads.put(e, tmp);
//            }
        });

        AtomicInteger rowNumber = new AtomicInteger();
        countryLeads.forEach((k, v) -> {
            Row row = sheet.createRow(rowNumber.getAndIncrement());
            row.createCell(0).setCellValue(k.getEnName());
            row.createCell(1).setCellValue(v.get(2));
            row.createCell(2).setCellValue(v.get(0));
            row.createCell(3).setCellValue(v.get(1));
        });

        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }

        try(FileOutputStream fileOut = new FileOutputStream(Config.LEADERS_FILE)) {
            workbook.write(fileOut);
            workbook.close();
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }
    }

    public static void generateStatistics(List<TeamInfo> juniors, List<TeamInfo> seniors, List<TeamInfo> teams, List<Person> guests) {
        Map<OS, List<Person>> osNumbers = new EnumMap<>(OS.class);
        Map<ShirtSize, Set<Person>> shirtsNumbers = new EnumMap<>(ShirtSize.class);
        StringBuilder sb = new StringBuilder();

        for (TeamInfo team : teams) {
            for (Person contestant : team.getContestants()) {
                osNumbers.putIfAbsent(contestant.getOperatingSystem(), new ArrayList<>());
                osNumbers.get(contestant.getOperatingSystem()).add(contestant);

                shirtsNumbers.putIfAbsent(contestant.getShirtSize(), new HashSet<>());
                shirtsNumbers.get(contestant.getShirtSize()).add(contestant);
            }

            if (team.getLeader() != null) {
                shirtsNumbers.putIfAbsent(team.getLeader().getShirtSize(), new HashSet<>());
                shirtsNumbers.get(team.getLeader().getShirtSize()).add(team.getLeader());
            }

            if (team.getDepLeader() != null) {
                shirtsNumbers.putIfAbsent(team.getDepLeader().getShirtSize(), new HashSet<>());
                shirtsNumbers.get(team.getDepLeader().getShirtSize()).add(team.getDepLeader());
            }
        }

        guests.forEach(e -> {
            shirtsNumbers.putIfAbsent(e.getShirtSize(), new HashSet<>());
            shirtsNumbers.get(e.getShirtSize()).add(e);
        });

        sb.append("=== JUNIORS ===\n");
        //sb.append(getStatistics(juniors.stream().filter(e -> e.getCountry() != Country.BG).collect(Collectors.toList())));
        sb.append(getStatistics(juniors));

        sb.append("\n=== SENIORS ===\n");
        //sb.append(getStatistics(seniors.stream().filter(e -> e.getCountry() != Country.BG).collect(Collectors.toList())));
        sb.append(getStatistics(seniors));

        sb.append("\n=== ALL ===\n");
        //sb.append(getStatistics(teams.stream().filter(e -> e.getCountry() != Country.BG).collect(Collectors.toList())));
        sb.append(getStatistics(teams));

        sb.append("\nNumber of guests: ").append(guests.size()).append("\n");

        addOsStat(osNumbers, sb);

        addShirtsStat(shirtsNumbers, sb);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STATISTICS_FILE))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }
    }

    private static void addOsStat(Map<OS, List<Person>> osNumbers, StringBuilder sb) {
        sb.append("\n=== OS ===\n");
        for (OS o : OS.values()) {
            if (osNumbers.containsKey(o)) {
                if (o == OS.EMPTY || o == OS.NONE) {
                    sb.append(o).append(" : ").append(osNumbers.get(o).stream().map(Person::getEnName).collect(Collectors.joining(", "))).append("\n");
                } else {
                    sb.append(o).append(" : ").append(osNumbers.get(o).size()).append("\n");
                }
            }
        }
    }

    private static void addShirtsStat(Map<ShirtSize, Set<Person>> shirtsNumbers, StringBuilder sb) {
        sb.append("\n=== SHIRT SIZES ===\n");
        for (ShirtSize o : ShirtSize.values()) {
            if (shirtsNumbers.containsKey(o)) {
                if (o == ShirtSize.NONE) {
                    sb.append(o).append(" : ").append(shirtsNumbers.get(o).stream().map(Person::getEnName).collect(Collectors.joining(", "))).append("\n");
                } else {
                    sb.append(o).append(" : ").append(shirtsNumbers.get(o).size()).append("\n");
                }
            }
        }
    }

    private static String getStatistics(List<TeamInfo> teams) {
        StringBuilder sb = new StringBuilder();
        sb.append("Number of teams: ").append(teams.size()).append("\n");

        int numberOfContestants = (int) teams.stream()
                .flatMap(t -> t.getContestants().stream())
                .filter(name -> !name.hasEmptyName())
                .count();
        sb.append("Number of contestants: ").append(numberOfContestants).append("\n");

        Set<Person> leaders = new HashSet<>();
        teams.forEach(t -> {
            if (t.getLeader() != null && !" ".equals(t.getLeader().getEnName())) {
                leaders.add(t.getLeader());
            }
            if (t.getDepLeader() != null && !" ".equals(t.getDepLeader().getEnName())) {
                leaders.add(t.getDepLeader());
            }
        });
        sb.append("Number of leaders: ").append(leaders.size()).append("\n");

        String listOfCountries = teams.stream()
                .map(t -> t.getCountry().toString())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        sb.append("Countries: ").append(listOfCountries).append("\n");

        return sb.toString();
    }

    public static void generateContestantsTable(List<TeamInfo> niors, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Juniors");

        int rowNumber = 0;
        for (TeamInfo team : niors) {
            for (Person contestant : team.getContestants()) {
                if (!contestant.hasEmptyName()) {
                    Row row = sheet.createRow(rowNumber);
                    row.createCell(0).setCellValue(team.getCountry().getEnName());
                    row.createCell(1).setCellValue(team.getEnTeamName());
                    row.createCell(2).setCellValue(contestant.getEnName());
                    row.createCell(3).setCellValue(contestant.getOperatingSystem().name());
                    rowNumber++;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }

        try(FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
            workbook.close();
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }
    }

    public static void generateTeamsTable(List<TeamInfo> teams) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Participants");

        int rowNumber = 0;
        TeamInfo oldTeam = null;
        for (TeamInfo team : teams) {
            Row row = sheet.createRow(rowNumber);

            row.createCell(0).setCellValue(team.getSeniority().name());
            row.createCell(1).setCellValue(team.getCountry().getEnName());
            row.createCell(2).setCellValue(team.getEnTeamName());
            row.createCell(3).setCellValue(team.getLeader().getEnName());
            if (team.getDepLeader() != null) {
                row.createCell(4).setCellValue(team.getDepLeader().getEnName());
            }
            for (Person contestant : team.getContestants()) {
                row.createCell(5).setCellValue(contestant.getEnName());
                row = sheet.createRow(++rowNumber);
            }
        }

        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }

        try(FileOutputStream fileOut = new FileOutputStream(Config.TEAMS_FILE)) {
            workbook.write(fileOut);
            workbook.close();
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }
    }
}
