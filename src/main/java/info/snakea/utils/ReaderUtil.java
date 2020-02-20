package info.snakea.utils;

import info.snakea.Config;
import info.snakea.artefacts.*;
import info.snakea.artefacts.attributes.Country;
import info.snakea.artefacts.attributes.OS;
import info.snakea.artefacts.attributes.Seniority;
import info.snakea.artefacts.attributes.ShirtSize;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReaderUtil {
    private static final int COUNTRY_COL = 0;
    private static final int TEAM_NAME_COL = 1;
    private static final int LEADER_NAME = 2;
    private static final int LEADER_SURNAME = 3;
    private static final int LEADER_FAMILY = 4;
    private static final int LEADER_SHIRT_SIZE = 6;
    private static final int DEP_LEADER_NAME = 7;
    private static final int DEP_LEADER_SURNAME = 8;
    private static final int DEP_LEADER_FAMILY = 9;
    private static final int DEP_LEADER_SHIRT_SIZE = 11;
    private static final int CONTESTANT_NAME = 12;
    private static final int CONTESTANT_SURNAME = 13;
    private static final int CONTESTANT_FAMILY = 14;
    private static final int DATE_OF_BIRTH = 15;
    private static final int CONTESTANT_OS = 16;
    private static final int CONTESTANT_SHIRT_SIZE = 17;

    public static List<TeamInfo> readDataFiles(String sourcePath) {
        List<TeamInfo> data = new ArrayList<>();

        try {
            Files.list(Paths.get(sourcePath))
                .filter(e -> Files.isRegularFile(e) && !e.getFileName().toString().contains("~") )
                .forEach(e -> data.addAll(readData(e.toString(), Config.SKIP_LINES)));
        } catch (IOException e) {
            LogUtil.LOGGER.severe("Problem loading file: " + sourcePath);
        }

        return data;
    }

    private static List<TeamInfo> readData(String sourcePath, int skippedLines) {
        List<TeamInfo> data = new ArrayList<>();

        TeamInfo team = new TeamInfo();
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(new File(sourcePath)))) {
            for (int i = 0; i < 2; i++) {
                Sheet dataTypeSheet = workbook.getSheetAt(i);
                int currentLine = 0;
                for (Row currentRow : dataTypeSheet) {
                    if (currentLine < skippedLines || currentRow.getCell(COUNTRY_COL) == null
                            || currentRow.getCell(CONTESTANT_NAME) == null) {
                        currentLine++;
                        continue;
                    }

                    if (currentRow.getCell(COUNTRY_COL).getCellType() != CellType.BLANK) {
                        team = createTeam(currentRow);
                        team.setSeniority(Seniority.values()[i]);

                        if (!"TEAM".equalsIgnoreCase(team.getEnTeamName())) {
                            data.add(team);
                        }
                    } else if (currentRow.getCell(CONTESTANT_NAME).getCellType() != CellType.BLANK) {
                        addContestant(team, currentRow);
                    }
                }
            }
        } catch (NotOfficeXmlFileException e) {
            LogUtil.LOGGER.severe(e.getMessage() + " : " + sourcePath);
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }

        return data;
    }

    private static TeamInfo createTeam(Row currentRow) {
        TeamInfo info = new TeamInfo();

        info.setCountry(Country.getCountry(StringUtil.removeSpecChars(currentRow.getCell(COUNTRY_COL).getStringCellValue())));

        info.setEnTeamName(getCell(currentRow, TEAM_NAME_COL));
        info.setBgTeamName(getCell(currentRow, TEAM_NAME_COL));

        Person leader = getPerson(getCell(currentRow, LEADER_NAME),
                                  getCell(currentRow, LEADER_SURNAME),
                                  getCell(currentRow, LEADER_FAMILY));
        leader.setShirtSize(ShirtSize.getSize(getCell(currentRow, LEADER_SHIRT_SIZE)));

        if (!" ".equals(leader.getEnName())) {
            info.setLeader(leader);
        }

        Person deputy = getPerson(getCell(currentRow, DEP_LEADER_NAME),
                                  getCell(currentRow, DEP_LEADER_SURNAME),
                                  getCell(currentRow, DEP_LEADER_FAMILY));
        deputy.setShirtSize(ShirtSize.getSize(getCell(currentRow, DEP_LEADER_SHIRT_SIZE)));

        if (!" ".equals(deputy.getEnName())) {
            info.setDepLeader(deputy);
        }

        info.setContestants(new ArrayList<>());

        addContestant(info, currentRow);

        return info;
    }

    private static void addContestant(TeamInfo team, Row currentRow) {
        Person contestant = getPerson(getCell(currentRow, CONTESTANT_NAME),
                                      getCell(currentRow, CONTESTANT_SURNAME),
                                      getCell(currentRow, CONTESTANT_FAMILY));
        contestant.setShirtSize(ShirtSize.getSize(getCell(currentRow, CONTESTANT_SHIRT_SIZE)));
        contestant.setDateOfBirth(getCell(currentRow, DATE_OF_BIRTH));
        contestant.setOperatingSystem(OS.getOS(getCell(currentRow, CONTESTANT_OS)));

        team.getContestants().add(contestant);
    }

    private static Person getPerson(String name, String surname, String familyname) {
        if (name.isEmpty()) {
            return new Person();
        }

        if (familyname.isEmpty()) {
            return new Person(name, surname);
        } else {
            return new Person(name, familyname);
        }
    }

    private static String getCell(Row currentRow, int cellNumber) {
        if (currentRow.getPhysicalNumberOfCells() >= cellNumber
                && currentRow.getCell(cellNumber) != null
                && currentRow.getCell(cellNumber).getCellType() != CellType.BLANK) {

            switch (currentRow.getCell(cellNumber).getCellType()) {
                case NUMERIC:
                    return String.valueOf(currentRow.getCell(cellNumber).getNumericCellValue());
                case FORMULA:
                    switch (currentRow.getCell(cellNumber).getCachedFormulaResultType()) {
                        case NUMERIC:
                            return String.valueOf(currentRow.getCell(cellNumber).getNumericCellValue());
                        default:
                            return StringUtil.removeSpecChars(currentRow.getCell(cellNumber).getStringCellValue());
                    }
                default:
                    return StringUtil.removeSpecChars(currentRow.getCell(cellNumber).getStringCellValue());
            }
        } else return "";
    }

    public static List<Person> readDataFilesForGuests(String sourcePath) {
        List<Person> data = new ArrayList<>();

        try {
            Files.list(Paths.get(sourcePath))
                    .filter(e -> Files.isRegularFile(e) && !e.getFileName().toString().contains("~") )
                    .forEach(e -> data.addAll(readGuestData(e.toString(), Config.SKIP_LINES)));
        } catch (IOException e) {
            LogUtil.LOGGER.severe("Problem loading file: " + sourcePath);
        }

        return data;
    }

    private static Collection<? extends Person> readGuestData(String sourcePath, int skippedLines) {
        List<Person> data = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(new File(sourcePath)))) {
            Sheet dataTypeSheet = workbook.getSheetAt(2);
            int currentLine = 0;
            for (Row currentRow : dataTypeSheet) {
                if (currentLine < skippedLines || currentRow.getCell(0) == null) {
                    currentLine++;
                    continue;
                }

                if (currentRow.getCell(0).getCellType() != CellType.BLANK) {
                    Person person = getPerson(getCell(currentRow, 0),
                            getCell(currentRow, 1),
                            getCell(currentRow, 2));
                    person.setShirtSize(ShirtSize.getSize(getCell(currentRow, 3)));
                    person.setCountry(getCell(currentRow, 4));
                    //person.setCountry(sourcePath);

                    data.add(person);
                }
            }
        } catch (NotOfficeXmlFileException e) {
            LogUtil.LOGGER.severe(e.getMessage() + " : " + sourcePath);
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }

        return data;
    }
}
