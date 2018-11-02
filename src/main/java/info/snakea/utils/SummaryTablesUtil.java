package info.snakea.utils;

import info.snakea.Config;
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
import java.util.stream.Collectors;

import static info.snakea.Config.STATISTICS_FILE;

public class SummaryTablesUtil {

    private SummaryTablesUtil() {
        super();
    }

    public static void generateLeadersTable(List<TeamInfo> teams) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Leaders");

        Map<String, List<Person>> countryLeads = new HashMap<>();
        teams.forEach(t -> {
            String country = t.getCountry().getEnName();
            countryLeads.putIfAbsent(country, new ArrayList<>());
            countryLeads.get(country).add(t.getLeader());
            countryLeads.get(country).add(t.getDepLeader());
        });


        int rowNumber = 0;
        for (Map.Entry<String, List<Person>> country : countryLeads.entrySet()) {
            for (Person lead : country.getValue()) {
                if (!lead.hasEmptyName()) {
                    Row row = sheet.createRow(rowNumber);
                    row.createCell(0).setCellValue(lead.getEnName().split(" ")[0]);
                    row.createCell(1).setCellValue(lead.getEnName().split(" ")[1]);
                    row.createCell(2).setCellValue(country.getKey());
                    rowNumber++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        try(FileOutputStream fileOut = new FileOutputStream(Config.LEADERS_FILE)) {
            workbook.write(fileOut);
            workbook.close();
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }
    }

    public static void generateStatistics(List<TeamInfo> juniors, List<TeamInfo> seniors, List<TeamInfo> teams) {
        Map<OS, List<Person>> osNumbers = new EnumMap<>(OS.class);
        Map<ShirtSize, List<Person>> shirtsNumbers = new EnumMap<>(ShirtSize.class);
        StringBuilder sb = new StringBuilder();

        for (TeamInfo team : teams) {
            for (Person contestant : team.getContestants()) {
                osNumbers.putIfAbsent(contestant.getOperatingSystem(), new ArrayList<>());
                osNumbers.get(contestant.getOperatingSystem()).add(contestant);

                shirtsNumbers.putIfAbsent(contestant.getShirtSize(), new ArrayList<>());
                shirtsNumbers.get(contestant.getShirtSize()).add(contestant);
            }
        }

        sb.append("=== JUNIORS ===\n");
        sb.append(getStatistics(juniors));

        sb.append("\n=== SENIORS ===\n");
        sb.append(getStatistics(seniors));

        sb.append("\n=== ALL ===\n");
        sb.append(getStatistics(teams));

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

    private static void addShirtsStat(Map<ShirtSize, List<Person>> shirtsNumbers, StringBuilder sb) {
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
        teams.forEach(t -> { leaders.add(t.getLeader()); leaders.add(t.getDepLeader()); });
        sb.append("Number of leaders: ").append(leaders.size()).append("\n");

        String listOfCountries = teams.stream()
                .map(t -> t.getCountry().toString())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        sb.append("Countries: ").append(listOfCountries).append("\n");

        return sb.toString();
    }
}
