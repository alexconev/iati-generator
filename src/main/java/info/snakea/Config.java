package info.snakea;

import java.util.HashMap;
import java.util.Map;

public class Config {

    static final String REGISTRATIONS_PATH = "C:\\Users\\Alex\\Desktop\\all_pics_iati\\tables";
    public static final String IMAGES_PATH = "C:\\Users\\Alex\\Desktop\\all_pics_iati\\";
    //static final String REGISTRATIONS_PATH = "C:\\Users\\Alex\\Desktop\\all_pics_iati\\tables\\tmp";
    public static final int SKIP_LINES = 2;

    public static final String PATH_TO_IMAGES = "http://iati-shu.org/wp-content/contestants/";
    public static final String NO_IMAGE = "http://iati-shu.org/wp-content/uploads/2017/11/noimage.jpg";

    public static final Map<String, String> participantImages = new HashMap<>();
    public static final Map<String, String> bgTeamNames = new HashMap<>();
    public static final Map<String, String> enTeamNames = new HashMap<>();

    static {
        participantImages.put("Adrian Ibovski", "Anrian_Ibovski.jpg");
        participantImages.put("Adrian-Emanuel Dicu", "Adrian_Emanuel_Dicu.jpg");
        participantImages.put("Albert Greaca", "Albert_Antoniu_Greaca.jpg");
        participantImages.put("Alexandra-Maria Udriștoiu", "Alexandra_Maria_Udristoiu.jpg");
        participantImages.put("Alexandru Dobleagă", "Dobleaga _Alexandru.jpg");
        participantImages.put("Alexandru Raul Todoran", "Todoran Alexandru.jpg");
        participantImages.put("Andrei Moldovan", "Moldovan _Andrei.jpg");
        participantImages.put("Andrey Stankevich", "Stankevich_Andrey.jpg");
        participantImages.put("Armen Andreasyan", "Andreasyan_Armen.jpg");
        participantImages.put("Bilyana Indjeva", "Biliana_Indjeva.jpg");
        participantImages.put("Bogdan-Petru Pop", "Pop_Bogdan_Petru.jpg");
        participantImages.put("Cezar Trișcă-Vicol", "Trisca_Vicol_Cezar.jpg");
        participantImages.put("Denis-Andrei Banu", "Banu_ Denis_Andrei.jpg");
        participantImages.put("Deyan Hadzhi-Manich", "Deyan_Nadzi-Manich.jpg");
        participantImages.put("Filip Ștefan Tudose", "Filip-Ștefan_Tudose.jpg");
        participantImages.put("Flaviu-Cristian Verde", "Verde _Flaviu_Cristian.jpg");
        participantImages.put("Iliyas Noman", "Iliias_Noman.jpg");
        participantImages.put("Ioan Popescu", "Popescu_Ioan.jpg");
        participantImages.put("Julia Dimitrova", "Yuliya_Dimitrova.jpg");
        participantImages.put("Livia Magureanu", "Magureanu_Livia.jpg");
        participantImages.put("Maria-Alexa Tudose", "Tudose_Alexa_Maria.jpg");
        participantImages.put("Marius Nicoli", "NICOLI_MARIUS.jpg");
        participantImages.put("Mathew Mashkov", "Mathew_Petkov_Mashkov.jpg");
        participantImages.put("Mihai Spinei", "Spinei_Mihai.jpg");
        participantImages.put("Nikolai Borisov", "Borisov_Nikolai.jpg");
        participantImages.put("Radostim Handarov", "Radostin_Handarov.JPG");
        participantImages.put("Radu-Mihai Nicolae", "Radu_Mihai_Nicolae.jpg");
        participantImages.put("Ruxandra-Laura Nanu", "Ruxandra_Laura_Nanu.jpg");
        participantImages.put("Theodor Pierre Moroianu", "Moroianu_Theodor_Pierre.jpg");
        participantImages.put("Victor Krivoshchekov", "Viktor_Krivoshchekov.jpg");
        participantImages.put("Victor Melinceanu", "Melinceanu_Victor.jpg");
        participantImages.put("Zornica Dzhenkova", "Zornitsa_Dzhenkova.jpg");
        participantImages.put("Șerban Ion Cercelescu", "Cercelescu_Serban_Ion.jpg");
        participantImages.put("Ștefan Țaga", "Taga _Stefan.jpg");
        participantImages.put("Елена, Elena Димитрова, Dimitrova", "Elena_Dimitrova.jpg");
        participantImages.put("Dan-Octavian Dumitrașcu", "Dumitrascu_Dan-Octavian.jpg");
        participantImages.put("Danil Klishch", "Danil_Klisch.jpg");
        participantImages.put("Octavian Dumitrașcu", "Dumitrascu_Dan-Octavian.jpg");
        participantImages.put("Alex Cvetanov", "Aleks_Tsvetanov.jpg");
        participantImages.put("Peter Penchev", "Petar_Penchev.jpg");
        participantImages.put("Antonio Zadgorski", "Antonio_Zadgorsky.jpg");
        participantImages.put("Cvetan Ivanov", "Tsvetan_Ivanov.jpg");
        participantImages.put("Iulia Slănină", "Iulia_Slanina.jpg");
        participantImages.put("Tadija Šebez", "Tadija_Sebez.jpg");
        participantImages.put("Vladimir Milovanović", "Vladimir_Milovanovic.jpg");
        participantImages.put("Marko Šišović", "Marko_Sisovic.jpg");
        participantImages.put("Mateja Vukelić", "Mateja_Vukelic.jpg");
        participantImages.put("Miloš Medić", "Milos_Medic.jpg");
        participantImages.put("Mladen Puzić", "Mladen_Puzic.jpg");
        participantImages.put("Filip Bojković", "Filip_Bojkovic.jpg");


        bgTeamNames.put("Armenia1", "Национален");
        bgTeamNames.put("Bulgaria1", "Национален 1");
        bgTeamNames.put("Bulgaria 1", "Национален 1");
        bgTeamNames.put("Bulgaria2", "Национален 2");
        bgTeamNames.put("Bulgaria 2", "Национален 2");
        bgTeamNames.put("Burgas", "Бургас");
        bgTeamNames.put("Gabrovo", "Габрово");
        bgTeamNames.put("MG", "Пловдив");
        bgTeamNames.put("VnJunior", "Варна");
        bgTeamNames.put("Russia ISIJ", "ISIJ");
        bgTeamNames.put("Russia Juniors - 1", "Отбор 1");
        bgTeamNames.put("Russia Juniors - 2", "Отбор 2");
        bgTeamNames.put("Russia Juniors - 3", "Отбор 3");
        bgTeamNames.put("Tatarstan-1", "Татарстан 1");
        bgTeamNames.put("Tatarstan-2", "Татарстан 2");
        bgTeamNames.put("BG_Gabrovo-Pleven", "Габрово-Плевен");
        bgTeamNames.put("Ruse - V.Tarnovo", "Русе-Търново");
        bgTeamNames.put("Sofia1", "София 1");
        bgTeamNames.put("Sofia2", "София 2");
        bgTeamNames.put("VarnaSen1", "Варна 1");
        bgTeamNames.put("VarnaSen2", "Варна 2");
        bgTeamNames.put("Yambol", "Ямбол");
        bgTeamNames.put("ROMANIA (National Senior)", "Национален");
        bgTeamNames.put("Russia 1", "Отбор 1");
        bgTeamNames.put("Romania – Bucharest CNITV juniors", "CNITV");
        bgTeamNames.put("senior", "Национален");
        bgTeamNames.put("junior", "Национален");

        bgTeamNames.put("ROMANIA 1 (National Junior)", "Национален");
        bgTeamNames.put("ROMANIA 2 (ICHB Juniors)", "Букурещ ICHB");
        bgTeamNames.put("Russia 2", "Отбор 2");
        bgTeamNames.put("Russia 3", "Отбор 3");
        bgTeamNames.put("Russia 4", "Отбор 4");
        bgTeamNames.put("Russia 5", "Отбор 5");
        bgTeamNames.put("Russia 6", "Отбор 6");
        bgTeamNames.put("BULGARIA - GABROVO", "Габрово");
        bgTeamNames.put("Varna", "Варна");
        bgTeamNames.put("Serbia", "Национален");
        bgTeamNames.put("Azerbaijan #1", "Национален");
        bgTeamNames.put("Sofia", "София");
        bgTeamNames.put("Plovdiv - Gabrovo ", "Пловдив-Габрово");
        bgTeamNames.put("POLAND", "Национален");
        bgTeamNames.put("Switzerland", "Национален");
        bgTeamNames.put("Ploiești & Câmpulung (Seniors)", "Плоещ & Мушчел");
        bgTeamNames.put("Ploiești & Câmpulung (Juniors)", "Плоещ & Мушчел");
        bgTeamNames.put("Bulgaria, National-2", "Национален 2");
        bgTeamNames.put("Varna-3", "Варна 3");
        bgTeamNames.put("Varna-1", "Варна 1");
        bgTeamNames.put("Varna-2", "Варна 2");
        bgTeamNames.put("SofiaS1", "София 1");
        bgTeamNames.put("SofiaS2", "София 2");
        bgTeamNames.put("Pleven", "Плевен");
        bgTeamNames.put("Ukraine-Junior", "Национален");
        bgTeamNames.put("Ukraine-Senior", "Национален");
        bgTeamNames.put("National", "Национален");

        bgTeamNames.put("Shumen", "Шумен");
        bgTeamNames.put("ROMANIA 1 (National Seniors)", "Национален");
        bgTeamNames.put("ROMANIA (National Junior)", "Национален");
        bgTeamNames.put("ROMANIA 2 (ICHB Seniors)", "ICHB");
        bgTeamNames.put("ROMANIA 4 (Craiova Seniors)", "Крайова");
        bgTeamNames.put("Romania – Bucharest CNITV seniors", "CNITV");
        bgTeamNames.put("Plovdiv - Yambol", "Пловдив - Ямбол");
        bgTeamNames.put("Ruse", "Русе");
        bgTeamNames.put("Shumen 2", "Шумен");

        enTeamNames.put("senior", "National");
        enTeamNames.put("junior", "National");
        enTeamNames.put("Armenia1", "National");
        enTeamNames.put("Romania – Bucharest CNITV juniors", "CNITV");
        enTeamNames.put("MG", "Plovdiv");
        enTeamNames.put("VnJunior", "Varna");
        enTeamNames.put("Ploiești & Câmpulung (Seniors)", "Ploiești & Câmpulung Muscel");
        enTeamNames.put("Ploiești & Câmpulung (Juniors)", "Ploiești & Câmpulung Muscel");
        enTeamNames.put("Russia ISIJ", "ISIJ");
        enTeamNames.put("Russia Juniors - 1", "Team 1");
        enTeamNames.put("Russia Juniors - 2", "Team 2");
        enTeamNames.put("Russia Juniors - 3", "Team 3");
        enTeamNames.put("BG_Gabrovo-Pleven", "Gabrovo-Pleven");
        enTeamNames.put("VarnaSen1", "Varna 1");
        enTeamNames.put("VarnaSen2", "Varna 2");
        enTeamNames.put("ROMANIA (National Senior)", "National");
        enTeamNames.put("Tatarstan-1", "Tatarstan 1");

        enTeamNames.put("ROMANIA (National Junior)", "National");
        enTeamNames.put("ROMANIA 2 (ICHB Juniors)", "Bucharest ICHB");
        enTeamNames.put("ROMANIA 3 (Ploiești & Câmpulung Muscel - Juniors)", "Ploiești & Câmpulung Muscel");
        enTeamNames.put("Russia 1", "Team 1");
        enTeamNames.put("Russia 2", "Team 2");
        enTeamNames.put("Russia 3", "Team 3");
        enTeamNames.put("Russia 4", "Team 4");
        enTeamNames.put("Russia 5", "Team 5");
        enTeamNames.put("Russia 6", "Team 6");
        enTeamNames.put("BULGARIA - GABROVO", "Gabrovo");
        enTeamNames.put("Bulgaria 1", "National 1");
        enTeamNames.put("Bulgaria 2", "National 2");
        enTeamNames.put("Azerbaijan #1", "National");
        enTeamNames.put("Romania – Bucharest CNITV seniors", "CNITV");
        enTeamNames.put("POLAND", "National");
        enTeamNames.put("Serbia", "National");
        enTeamNames.put("Bulgaria, National-2", "National 2");
        enTeamNames.put("Varna-3", "Varna 3");
        enTeamNames.put("Varna-1", "Varna 1");
        enTeamNames.put("Varna-2", "Varna 2");
        enTeamNames.put("SofiaS1", "Sofia 1");
        enTeamNames.put("SofiaS2", "Sofia 2");
        enTeamNames.put("Shumen 1", "Shumen");
        enTeamNames.put("ROMANIA 1 (National Seniors)", "National");
        enTeamNames.put("ROMANIA 2 (ICHB Seniors)", "ICHB");
        enTeamNames.put("ROMANIA 3 (Ploiești & Câmpulung Muscel - Seniors)", "Ploiești & Câmpulung Muscel");
        enTeamNames.put("ROMANIA 4 (Craiova Seniors)", "Craiova");
        enTeamNames.put("RОMANIA 5 (Bucharest CNITV)", "Bucharest CNITV");
        enTeamNames.put("Switzerland", "National");
        enTeamNames.put("Shumen 2", "Shumen");
        enTeamNames.put("Ukraine-Junior", "National");
        enTeamNames.put("Ukraine-Senior", "National");

    }

    // === DO NOT EDIT BELOW ===

    private Config() {
        super();
    }

    static final String JUNIORS_HTML_FILE_BG = "./results/juniors_bg.html";
    static final String JUNIORS_HTML_FILE_EN = "./results/juniors_en.html";
    static final String SENIORS_HTML_FILE_BG = "./results/seniors_bg.html";
    static final String SENIORS_HTML_FILE_EN = "./results/seniors_en.html";
    public static final String STATISTICS_FILE = "./results/stats.txt";
    public static final String LEADERS_FILE = "./results/leaders.xlsx";
    public static final String JUNIORS_FILE = "./results/juniors_country.xlsx";
    public static final String SENIORS_FILE = "./results/seniors_country.xlsx";
    public static final String TEAMS_FILE = "./results/teams.xlsx";

    public static final String TL_EN_TITLE = "team leader";
    public static final String DEPTL_EN_TITLE = "deputy leader";
    public static final String CONTESTANT_EN_TITLE = "contestant";

    public static final String TL_BG_TITLE = "ръководител";
    public static final String DEPTL_BG_TITLE = "зам. ръководител";
    public static final String CONTESTANT_BG_TITLE = "състезател";
}
