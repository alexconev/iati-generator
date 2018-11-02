package info.snakea.utils;

import info.snakea.artefacts.*;
import info.snakea.artefacts.attributes.Country;
import info.snakea.artefacts.attributes.OS;
import info.snakea.artefacts.attributes.ShirtSize;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderUtil {
    private static final int COUNTRY_COL = 0;
    private static final int TEAM_NAME_COL = 1;
    private static final int LEADER_NAME = 2;
    private static final int LEADER_SURNAME = 3;
    private static final int LEADER_FAMILY = 4;
    private static final int LEADER_SHIRT_SIZE = 10;
    private static final int DEP_LEADER_NAME = 11;
    private static final int DEP_LEADER_SURNAME = 12;
    private static final int DEP_LEADER_FAMILY = 13;
    private static final int DEP_LEADER_SHIRT_SIZE = 19;
    private static final int CONTESTANT_NAME = 20;
    private static final int CONTESTANT_SURNAME = 21;
    private static final int CONTESTANT_FAMILY = 22;
    private static final int CONTESTANT_OS = 23;
    private static final int CONTESTANT_SHIRT_SIZE = 28;

    public List<TeamInfo> readData(String sourcePath, int skippedLines) {
        List<TeamInfo> data = new ArrayList<>();

        TeamInfo team = new TeamInfo();
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(new File(sourcePath)))) {
            Sheet dataTypeSheet = workbook.getSheetAt(0);
            int currentLine = 0;
            for (Row currentRow : dataTypeSheet) {
                if (currentLine < skippedLines || currentRow.getCell(COUNTRY_COL) == null
                            || currentRow.getCell(CONTESTANT_NAME) == null) {
                    currentLine++;
                    continue;
                }

                if (currentRow.getCell(COUNTRY_COL).getCellType() != CellType.BLANK) {
                    team = createTeam(currentRow);
                    data.add(team);
                } else if (currentRow.getCell(CONTESTANT_NAME).getCellType() != CellType.BLANK) {
                    addContestant(team, currentRow);
                }
            }
        } catch (IOException e) {
            LogUtil.LOGGER.severe(e.getMessage());
        }

        return data;
    }

    private TeamInfo createTeam(Row currentRow) {
        TeamInfo info = new TeamInfo();

        info.setCountry(Country.getCountry(StringUtil.removeSpecChars(currentRow.getCell(COUNTRY_COL).getStringCellValue())));

        info.setEnTeamName(getCell(currentRow, TEAM_NAME_COL));
        info.setBgTeamName(getCell(currentRow, TEAM_NAME_COL));

        Person leader = getPerson(getCell(currentRow, LEADER_NAME),
                                  getCell(currentRow, LEADER_SURNAME),
                                  getCell(currentRow, LEADER_FAMILY));
        leader.setShirtSize(ShirtSize.getSize(getCell(currentRow, LEADER_SHIRT_SIZE)));

        info.setLeader(leader);

        Person deputy = getPerson(getCell(currentRow, DEP_LEADER_NAME),
                                  getCell(currentRow, DEP_LEADER_SURNAME),
                                  getCell(currentRow, DEP_LEADER_FAMILY));
        deputy.setShirtSize(ShirtSize.getSize(getCell(currentRow, DEP_LEADER_SHIRT_SIZE)));

        info.setDepLeader(deputy);

        info.setContestants(new ArrayList<>());

        addContestant(info, currentRow);

        return info;
    }

    private void addContestant(TeamInfo team, Row currentRow) {
        Person contestant = getPerson(getCell(currentRow, CONTESTANT_NAME),
                                      getCell(currentRow, CONTESTANT_SURNAME),
                                      getCell(currentRow, CONTESTANT_FAMILY));
        contestant.setShirtSize(ShirtSize.getSize(getCell(currentRow, CONTESTANT_SHIRT_SIZE)));
        contestant.setOperatingSystem(OS.getOS(getCell(currentRow, CONTESTANT_OS)));

        team.getContestants().add(contestant);
    }

    private Person getPerson(String name, String surname, String familyname) {
        if (name.isEmpty()) {
            return new Person();
        }

        if (familyname.isEmpty()) {
            return new Person(name, surname);
        } else {
            return new Person(name, familyname);
        }
    }

    private String getCell(Row currentRow, int cellNumber) {
        if (currentRow.getPhysicalNumberOfCells() >= cellNumber
                && currentRow.getCell(cellNumber) != null
                && currentRow.getCell(cellNumber).getCellType() != CellType.BLANK) {
            return StringUtil.removeSpecChars(currentRow.getCell(cellNumber).getStringCellValue());
        } else return "";
    }
}
