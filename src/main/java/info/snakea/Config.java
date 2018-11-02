package info.snakea;

import java.util.HashMap;
import java.util.Map;

public class Config {

    static final String SOURCE_PATH_JUNIORS = "C:\\Users\\Alex\\Downloads\\Finale_IATY_REG_FORM_2018_Juniors (1).xlsx";
    static final String SOURCE_PATH_SENIORS = "C:\\Users\\Alex\\Downloads\\Finale_IATY_REG_FORM_2018_Seniors (1).xlsx";
    static final int SKIP_LINES = 2;

    public static final String PATH_TO_IMAGES = "http://iati-shu.org/wp-content/contestants";
    public static final String NO_IMAGE = "http://iati-shu.org/wp-content/uploads/2017/11/noimage.jpg";

    public static final Map<String, String> participantImages = new HashMap<>();
    public static final Map<String, String> bgTeamNames = new HashMap<>();
    public static final Map<String, String> enTeamNames = new HashMap<>();

    static {
        participantImages.put("Dan-Octavian Dumitrașcu", "/juniors/Romania/RO1/Dumitrascu_Dan-Octavian.jpg");
        participantImages.put("Octavian Dumitrașcu", "/juniors/Romania/RO1/Dumitrascu_Dan-Octavian.jpg");
        participantImages.put("Bogdan Ciobanu", "/juniors/Romania/RO1/Ciobanu_Bogdan.jpg");
        participantImages.put("Alexandru Raul Todoran", "/juniors/Romania/RO1/Todoran_Alexandru_raul .jpg");
        participantImages.put("Eduard Valentin Dumitrescul", "/juniors/Romania/RO1/Dumitrescul_Edi.jpg");
        participantImages.put("Luca Mihnea Metehău", "/juniors/Romania/RO1/Metehau_Luca.jpg");
        participantImages.put("Flaviu Cristian Verde", "/juniors/Romania/RO1/Verde_Cristian.jpg");
        participantImages.put("Casian Patrascanu", "/juniors/Romania/RO2/Patrascanu_Casian.jpg");
        participantImages.put("Albert Greaca", "/juniors/Romania/RO2/Albert_Greaca.jpg");
        participantImages.put("Alexandru Luchianov", "/juniors/Romania/RO2/Alexandru_Luchianov.jpg");
        participantImages.put("Alexandru Ardelean", "/juniors/Romania/RO2/Alexandru_Ardelean.jpg");
        participantImages.put("Alexandru Peticaru", "/juniors/Romania/RO2/Alexandru_Peticaru.jpg");
        participantImages.put("Daniela Lica", "/juniors/Romania/RO3/Daniela_Lica.jpg");
        participantImages.put("Alexandru Dobleagă", "/juniors/Romania/RO3/Alexandru_Dobleaga.jpg");
        participantImages.put("Sebastian-Ion Predescu", "/juniors/Romania/RO3/Sebastian_Predescu.jpg");
        participantImages.put("Andrei Onuț", "/juniors/Romania/RO3/Andrei_Onut.jpg");
        participantImages.put("Ștefan Țaga", "/juniors/Romania/RO3/Stefan_Taga.jpg");
        participantImages.put("Elena Andreeva", "/juniors/Russia/RU1/Elena_Andreeva.jpg");
        participantImages.put("Shukhrat Azimuratov", "/juniors/Russia/RU1/Shukhrat_Azimuratov.jpg");
        participantImages.put("Fedor Ushakov", "/juniors/Russia/RU1/Fedor_Ushakov.jpg");
        participantImages.put("Anton Sadovnichiy", "/juniors/Russia/RU1/Anton_Sadovnichiy.jpg");
        participantImages.put("Maksim Shuklin", "/juniors/Russia/RU1/Maksim_Shuklin.jpg");
        participantImages.put("Konstantin Frolov", "/juniors/Russia/RU1/Konstantin_Frolov.jpg");
        participantImages.put("Dina Ziangaraeva", "/juniors/Russia/RU2/Dina_Ziangaraeva.jpg");
        participantImages.put("Ildar Yalalov", "/juniors/Russia/RU2/Ildar_Yalalov.jpg");
        participantImages.put("Bulat Minnekhanov", "/juniors/Russia/RU2/Bulat_Minnekhanov.jpg");
        participantImages.put("Kamil Salakhov", "/juniors/Russia/RU2/Kamil_ Salakhov.jpg");
        participantImages.put("Bulat Kharisov", "/juniors/Russia/RU2/Bulat_Kharisov.jpg");
        participantImages.put("Kamil Sharipov", "/juniors/Russia/RU2/Kamil_Sharipov.jpg");
        participantImages.put("Demid Kucherenko", "/juniors/Russia/RU3/Demid_Kucherenko.jpg");
        participantImages.put("Ekaterina Shilyaeva", "/juniors/Russia/RU3/Ekaterina_Shilyaeva.jpg");
        participantImages.put("Danil Klishch", "/juniors/Russia/RU3/Danil_Klishch.jpg");
        participantImages.put("Mikhail Budnikov", "/juniors/Russia/RU3/Mikhail_Budnikov.jpg");
        participantImages.put("Mark Kanafeev", "/juniors/Russia/RU3/Mark_Kanafeev.jpg");
        participantImages.put("Nikolai Borisov", "/juniors/Russia/RU4/Borisov_Nikolai.jpg");
        participantImages.put("Marina Kelina", "/juniors/Russia/RU4/KELINA_MARINA.jpg");
        participantImages.put("Polina Musina", "/juniors/Russia/RU4/MUSINA_POLINA.jpg");
        participantImages.put("Alisa Gladchenko", "/juniors/Russia/RU4/GLADCHENKO_ALISA.jpg");
        participantImages.put("Anastasiia Runova ", "/juniors/Russia/RU4/RUNOVA_ANASTASIIA.jpg");
        participantImages.put("Nikita Golubev", "/juniors/Russia/RU4/GOLUBEV_NIKITA.jpg");
        participantImages.put("Zornitsa Dzhenkova", "/juniors/Bulgaria/Gabrovo/Zornica_Dzhenkova.jpg");
        participantImages.put("Tsveta Todorova", "/juniors/Bulgaria/Gabrovo/Tsveta_Todorova.jpg");
        participantImages.put("Yordan Petkov", "/juniors/Bulgaria/Gabrovo/Jordan_Petkov.jpg");
        participantImages.put("Dobrin Bashev", "/juniors/Bulgaria/Gabrovo/Dobrin_Bashev.jpg");
        participantImages.put("Viktor Venkov", "/juniors/Bulgaria/Gabrovo/Viktor-Venkov.jpg");
        participantImages.put("Plamenka Hristova", "/juniors/Bulgaria/BG1/Plamenka_Hristova.jpg");
        participantImages.put("Andon Todorov", "/juniors/Bulgaria/BG1/Andon_Todorov.jpg");
        participantImages.put("Viktor Kozhuharov", "/juniors/Bulgaria/BG1/Viktor_Kozhuharov.jpg");
        participantImages.put("Georgi Petkov", "/juniors/Bulgaria/BG1/Georgi_Petkov.jpg");
        participantImages.put("Konstantin Kamenov", "/juniors/Bulgaria/BG1/Konstantin_Kamenov.jpg");
        participantImages.put("Bistra Taneva", "/juniors/Bulgaria/BG1/Bistra_Taneva.jpg");
        participantImages.put("Rumen Mihov", "/juniors/Bulgaria/BG2/Rumen_Mihov.jpg");
        participantImages.put("Velislav Garkov", "/juniors/Bulgaria/BG2/Velislav_Garkov.jpg");
        participantImages.put("Dimitar Nedelchev", "/juniors/Bulgaria/BG2/Dimitar_Nedelchev.jpg");
        participantImages.put("Atanas Buntov", "/juniors/Bulgaria/BG2/Atanas_Buntov.jpg");
        participantImages.put("Elena Dimitrova", "/juniors/Bulgaria/Varna/Elena_Dimitrova.jpg");
        participantImages.put("Stefan Minkov", "/juniors/Bulgaria/Varna/Stefan_Minkov.jpg");
        participantImages.put("Veselin Mitev", "/juniors/Bulgaria/Varna/Veselin_Mitev.jpg");
        participantImages.put("Tcvetoslav Mavrodiev", "/juniors/Bulgaria/Varna/Tsvetoslav_Mavrodiev.jpg");
        participantImages.put("Radostin Handarov", "/juniors/Bulgaria/Varna/Radostin_Handarov.jpg");
        participantImages.put("Atanas Dimitrov", "/juniors/Bulgaria/Sofia/Atanas_Dimitrov.jpg");
        participantImages.put("Ilias Noman", "/juniors/Bulgaria/Sofia/Ilias_Noman.jpg");
        participantImages.put("Ilia Petrov", "/juniors/Bulgaria/Sofia/Ilia_Petrov.jpg");
        participantImages.put("Viktor Mihailov", "/juniors/Bulgaria/Sofia/Viktor_Mihailov.jpg");
        participantImages.put("Nikola Maksimov", "/juniors/Bulgaria/Yambol-Grabovo/Nikola_Maximov.jpg");
        participantImages.put("Viktoriya Hristova", "/juniors/Bulgaria/Yambol-Grabovo/Viktoriya_Hristiva.jpg");
        participantImages.put("Sebastian Szubartowski", "/juniors/Poland/Sebastian_Szubartowski.jpg");
        participantImages.put("Łukasiewicz Bartosz", "/juniors/Poland/Bartosz.jpg");
        participantImages.put("Bartłomiej Czarkowski", "/juniors/Poland/Czarkowki.jpg");
        participantImages.put("Jan Strzeszyński", "/juniors/Poland/Jan.jpg");
        participantImages.put("Korneliusz Obarski", "/juniors/Poland/Korneliusz_Obarski.jpg");
        participantImages.put("Antoni Długosz", "/juniors/Poland/Antoni.jpg");
        participantImages.put("Isabela-Patricia Coman", "/juniors/Romania/RO4/Isabela-Patricia_Coman.jpg");
        participantImages.put("Mihnea Andreescu", "/juniors/Romania/RO4/Mihnea_Andreescu.jpg");
        participantImages.put("Costin Andrei Vlad", "/juniors/Romania/RO4/Costin_Andrei_Vlad.jpg");
        participantImages.put("Luca Perju-Verzotti", "/juniors/Romania/RO4/Perju-Verzotti_Luca.jpg");
        participantImages.put("Ilie Daniel Apostol", "/juniors/Romania/RO4/Apostol_Daniel.jpg");
        participantImages.put("Jelena Hadzi-Puric", "/juniors/Serbia/Jelena_Hadzi-Puric.jpg");
        participantImages.put("Jovan Bengin", "/juniors/Serbia/Jovan_Bengin.jpg");
        participantImages.put("Mateja Vukelić", "/juniors/Serbia/Mateja_Vukelic.jpg");
        participantImages.put("Miroslav Grubić", "/juniors/Serbia/Miroslav_Grubic.jpg");
        participantImages.put("Veljko Toljić", "/juniors/Serbia/Veljko_Toljic.jpg");
        participantImages.put("Zuzanna Ossowska", "/juniors/Poland/Zuzanna_Kiczak.jpg");
        participantImages.put("Ivo Dilov", "/juniors/Bulgaria/Sofia/Ivo_Dilov.jpg");
        participantImages.put("Katalina Grigorova", "/seniors/Bulgaria/Ruse/Katalina_Grigorova.jpg");
        participantImages.put("Aleksandar Krastev", "/seniors/Bulgaria/BG1/Aleksandar_Krastev.jpg");
        participantImages.put("Martin Kopchev", "/seniors/Bulgaria/BG1/Martin_Kopchev.jpg");
        participantImages.put("Petar Nyagolov", "/seniors/Bulgaria/BG1/Petar_Nyagolov.jpg");
        participantImages.put("Radoslav Dimitrov", "/seniors/Bulgaria/BG1/Radoslav_Dimitrov.jpg");
        participantImages.put("Atanas Dobrev", "/seniors/Bulgaria/Plovdiv_Yambol/Atanas_Dobrev.jpg");
        participantImages.put("Daniel Danailov", "/seniors/Bulgaria/Plovdiv_Yambol/Daniel_Danailov.jpg");
        participantImages.put("Daniel Velichkov", "/seniors/Bulgaria/Plovdiv_Yambol/Daniel_Velichkov.jpg");
        participantImages.put("Vasilena Tsvetanova", "/seniors/Bulgaria/Plovdiv_Yambol/Vasilena_Tsvetanova.jpg");
        participantImages.put("Kaloyan Spirov", "/seniors/Bulgaria/Ruse/Kaloyan_Spirov.jpg");
        participantImages.put("Valeri Stanchev", "/seniors/Bulgaria/Ruse/Valeri_Stanchev.jpg");
        participantImages.put("Aleksandar Vasilev", "/seniors/Bulgaria/Sofia1/Aleksandar_Vasilev.jpg");
        participantImages.put("Cvetan Ivanov", "/seniors/Bulgaria/Sofia1/Cvetan_Ivanov.jpg");
        participantImages.put("Dimo Chanev", "/seniors/Bulgaria/Sofia1/Dimo_Chanev.jpg");
        participantImages.put("Stanislav Nikolov", "/seniors/Bulgaria/Sofia1/Stanislav_Nikolov.jpg");
        participantImages.put("Stefania Tsvetkova", "/seniors/Bulgaria/Sofia1/Stefania_Tsvetkova.jpg");
        participantImages.put("Yordan Iliev", "/seniors/Bulgaria/Sofia1/Yordan_Iliev.jpg");
        participantImages.put("Ignes Simeonova", "/seniors/Bulgaria/Sofia2/Ignes_Simeonova.jpg");
        participantImages.put("Ivan Durev", "/seniors/Bulgaria/Sofia2/Ivan_Durev.jpg");
        participantImages.put("Kamen Pavlov", "/seniors/Bulgaria/Sofia2/Kamen_Pavlov.jpg");
        participantImages.put("Petar Petrov", "/seniors/Bulgaria/Sofia2/Petar_Petrov.jpg");
        participantImages.put("Spasian Todorov", "/seniors/Bulgaria/Sofia2/Spasian_Todorov.jpg");
        participantImages.put("Stanislava Todorova", "/seniors/Bulgaria/Sofia2/Stanislava_Todorova.jpg");
        participantImages.put("Dimitar Oparlakov", "/seniors/Bulgaria/Varna1/Dimitar_Oparlakov.jpg");
        participantImages.put("Kamelia Ivanova", "/seniors/Bulgaria/Varna1/Kamelia_Ivanova.jpg");
        participantImages.put("Ralitsa Andreeva", "/seniors/Bulgaria/Varna1/Ralitsa_Andreeva.jpg");
        participantImages.put("Tihomir Todorov", "/seniors/Bulgaria/Varna1/Tihomir_Todorov.jpg");
        participantImages.put("Julia Dimitrova", "/seniors/Bulgaria/Varna1/Yuliya_Dimitrova.jpg");
        participantImages.put("Lachezar Kemanov", "/seniors/Bulgaria/Varna2/Lachezar_Kemanov.jpg");
        participantImages.put("Mark Dragnev", "/seniors/Bulgaria/Varna2/Mark_Dragnev.jpg");
        participantImages.put("Martin Petrov", "/seniors/Bulgaria/Varna2/Martin_Petrov.jpg");
        participantImages.put("Nelly Mincheva", "/seniors/Bulgaria/Varna2/Nelly_Mincheva.jpg");
        participantImages.put("Angel Karchev", "/seniors/Bulgaria/Varna3/Angel_Karchev.jpg");
        participantImages.put("Hristo Hristov", "/seniors/Bulgaria/Varna3/Hristo_Hristov.jpg");
        participantImages.put("Kamen Hristov", "/seniors/Bulgaria/Varna3/Kamen_Hristov.jpg");
        participantImages.put("Alexandru Petrescu", "/seniors/Romania/RO5/Alexandru_Petrescu.jpg");
        participantImages.put("Andrei Coman", "/seniors/Romania/RO5/Andrei_COMAN.jpg");
        participantImages.put("Felix Pușcașu", "/seniors/Romania/RO5/Puscasu_Felix.jpg");
        participantImages.put("Robert Popovici", "/seniors/Romania/RO5/Popovici_Robert.jpg");
        participantImages.put("Marius Nicoli", "/seniors/Romania/RO4/NICOLI_MARIUS.jpg");
        participantImages.put("Adrian-Emanuel Dicu", "/seniors/Romania/RO4/DICU_ADRIAN-EMANUEL.jpg");
        participantImages.put("Alexandra-Maria Udriștoiu", "/seniors/Romania/RO4/ALEXANDRA-MARIA.jpg");
        participantImages.put("Radu-Mihai Nicolae", "/seniors/Romania/RO4/NICOLAE_RADU-MIHAI.jpg");
        participantImages.put("Ruxandra-Laura Nanu", "/seniors/Romania/RO4/NANU_RUXANDA-LAURA.jpg");
        participantImages.put("Laura Georgescu", "/seniors/Romania/RO2/Laura_Georgescu.jpg");
        participantImages.put("Matei Mirica", "/seniors/Romania/RO2/Matei_Mirica.jpg");
        participantImages.put("Mircea Donciu", "/seniors/Romania/RO2/Mircea_Donciu.jpg");
        participantImages.put("Serban Cercelescu", "/seniors/Romania/RO2/Serban_Cercelescu.jpg");
        participantImages.put("Eugen-Gheorghe Nodea", "/seniors/Romania/RO1/Nodea_Gheorghe_Eugen.jpg");
        participantImages.put("Radu Muntean", "/seniors/Romania/RO1/Muntean_Radu.jpg");
        participantImages.put("Maria-Alexa Tudose", "/seniors/Romania/RO1/Tudose_Maria_Alexa_poza.jpg");
        participantImages.put("Matei Tinca", "/seniors/Romania/RO1/Tinca_Matei_poza.jpg");
        participantImages.put("Theodor-Pierre Moroianu", "/seniors/Romania/RO1/Moroianu_Theodor_Pierre_poza.jpg");
        participantImages.put("Tiberiu Ioan Mușat", "/seniors/Romania/RO1/Musat_Tiberiu-Ioan_poza.jpg");
        participantImages.put("Bogdan Sitaru", "/seniors/Romania/RO3/Bogdan_Sitaru.jpg");
        participantImages.put("Bogdan-Petru Pop", "/seniors/Romania/RO3/Bogdan_Pop.jpg");
        participantImages.put("Ioan Popescu", "/seniors/Romania/RO3/Ioan_Popescu.jpg");
        participantImages.put("Alexey Khabibullin", "/seniors/Russia/Russia4/Aleksey_Khabibullin.jpg");
        participantImages.put("Azat Sultanov", "/seniors/Russia/Russia4/Azat_Sultanov.jpg");
        participantImages.put("Aleksandr Batyrgariev", "/seniors/Russia/Russia4/Aleksandr_Batyrgariev.jpg");
        participantImages.put("Arsenii Staroverov", "/seniors/Russia/Russia4/Arsenii_Staroverov.jpg");
        participantImages.put("Bulat Minnakhmetov", "/seniors/Russia/Russia4/Bulat_Minnakhmetov.jpg");
        participantImages.put("Timur Garaev", "/seniors/Russia/Russia4/Timur_Garaev.jpg");
        participantImages.put("Pascal Sommer", "/seniors/Switzerland/Pascal_Sommer.jpg");
        participantImages.put("Martin Chikov", "/seniors/Switzerland/Martin_Chikov.jpg");
        participantImages.put("Elias Boschung", "/seniors/Switzerland/Elias_Boschung.jpg");
        participantImages.put("Nicolas Camenisch", "/seniors/Switzerland/Nicolas_Camenisch.jpg");
        participantImages.put("Tobias Feigenwinter", "/seniors/Switzerland/Tobias_Feigenwinter.jpg");
        participantImages.put("Valentin Imbach", "/seniors/Switzerland/Valentin_Imbach.jpg");
        participantImages.put("Mariya Vasileva", "/seniors/Bulgaria/Plovdiv_Yambol/Mariya_Vasileva.jpg");
        participantImages.put("Ștefan Săvulescu", "/seniors/Romania/RO3/Stefan_Savulescu.jpg");
        participantImages.put("Sergiu Corlat", "/seniors/Moldova/ALFA/Sergiu_Corlat.jpg");
        participantImages.put("Andrei Braicov", "/seniors/Moldova/ALFA/Andrei_Braicov.jpg");
        participantImages.put("Alexandru Rudi", "/seniors/Moldova/ALFA/Alexandru_Rudi.jpg");
        participantImages.put("Claudiu Babin", "/seniors/Moldova/ALFA/Claudiu_Babin.jpg");
        participantImages.put("Gabriel Cojocaru", "/seniors/Moldova/ALFA/Gabriel_Cojocaru.jpg");
        participantImages.put("Oleg Danilov", "/seniors/Moldova/ALFA/Oleg_Danilov.jpg");
        participantImages.put("Grigore Vasilache", "/seniors/Moldova/DELTA/Grigore_Vasilache.jpg");
        participantImages.put("Alic Ciumeico", "/seniors/Moldova/DELTA/Alic_Ciumeico.jpg");
        participantImages.put("Daniel Hangan", "/seniors/Moldova/DELTA/Daniel_Hangan.jpg");
        participantImages.put("Nicolae Rusnac", "/seniors/Moldova/DELTA/Nicolae_Rusnac.jpg");
        participantImages.put("Victor Melnicianu", "/seniors/Moldova/DELTA/Melnicianu_Victor.jpg");
        participantImages.put("Elena Mitiasova", "/seniors/Russia/Russia5/Elena_Mitiasova.jpg");
        participantImages.put("Egor Erove", "/seniors/Russia/Russia5/Egor_Erov.jpg");
        participantImages.put("Maksimov Aleksei", "/seniors/Russia/Russia5/Aleksei_Maksimov.jpg");
        participantImages.put("Tagir Khamitov", "/seniors/Russia/Russia5/Tagir_Khamitov.jpg");
        participantImages.put("Timur Khasanov", "/seniors/Russia/Russia5/Timur_Khasanov.jpg");
        participantImages.put("Angela Globa", "/juniors/Moldova/Angela_Globa.jpg");
        participantImages.put("Madalina Griza", "/juniors/Moldova/Madalina_Griza.jpg");
        participantImages.put("Victor Purice", "/juniors/Moldova/Victor_Purice.jpg");
        participantImages.put("Artur Lukianov", "/juniors/Russia/RU5/Artur_Lukianov.jpg");
        participantImages.put("Emir Ziganshin", "/juniors/Russia/RU5/Ziganshin_Emir.jpg");
        participantImages.put("Ilia Tamiarov", "/juniors/Russia/RU5/Tamiarov_Ilia.jpg");
        participantImages.put("Nikolai Ninevskii", "/juniors/Russia/RU5/Nikolai_Ninevskii.jpg");
        participantImages.put("Sergei Mikhailin", "/juniors/Russia/RU6/Mikhailin.jpg");
        participantImages.put("Konstantin Skobeltsyn", "/juniors/Russia/RU6/Skobeltsyn.jpg");
        participantImages.put("Marko Šišović", "/seniors/Serbia/Marko_Sisovic.jpg");
        participantImages.put("Mladen Puzić", "/seniors/Serbia/Mladen_Puzic.jpg");
        participantImages.put("Pavle Martinović", "/seniors/Serbia/Pavle_Martinovic.jpg");
        participantImages.put("Tadjia Šebez", "/seniors/Serbia/Tadija_Sebez.jpg");
        participantImages.put("Ivo Karagyozov", "/seniors/Bulgaria/BG2/Ivo_Karagyozov.jpg");
        participantImages.put("Antani Gospodinov", "/seniors/Bulgaria/BG2/Antani_Gospodinov.jpg");
        participantImages.put("Zahari Marinov", "/seniors/Bulgaria/BG2/Zahari_Marinov.jpg");
        participantImages.put("Alexander Radoslavov", "/seniors/Bulgaria/BG2/Alexander_Radoslavov.jpg");
        participantImages.put("Armen Andreasyan", "/juniors/Armenia/Andreasyan_Armen.jpg");
        participantImages.put("Narek Beglaryan", "/seniors/Armenia/Beglaryan_Narek.jpg");
        participantImages.put("Samvel Andreasyan", "/seniors/Armenia/Andreasyan_Samvel.jpg");
        participantImages.put("Borislav Semerdzhiev", "/seniors/Bulgaria/SSHH/Borislav_Semerdzhiev.jpg");
        participantImages.put("Ivan Borisov", "/seniors/Bulgaria/SSHH/Ivan_Borisov.jpg");
        participantImages.put("Kolya Petrova", "/seniors/Bulgaria/SSHH/Kolya_Petrova.jpg");
        participantImages.put("Krasimira Yurukova", "/seniors/Bulgaria/SSHH/Krasimira_Yurukova.jpg");
        participantImages.put("Sali Basri", "/seniors/Bulgaria/SSHH/Sali_Basri.jpg");
        participantImages.put("Stoyan Malinin", "/seniors/Bulgaria/SSHH/Stoyan_Malinin.jpg");
        participantImages.put("Valentin Borisov", "/juniors/Bulgaria/Shumen/Valentin_Borisov.jpg");
        participantImages.put("Ferit Ismailov", "/seniors/Bulgaria/Shumen/Ferit_Ismailov.jpg");
        participantImages.put("Ivan Smilenov", "/seniors/Bulgaria/Shumen/Ivan_Smilenov.jpg");
        participantImages.put("Viktor Varbanov", "/seniors/Bulgaria/Shumen/Viktor_Varbanov.jpg");
        participantImages.put("Yordan Dimitrov", "/seniors/Bulgaria/Shumen/Yordan_Dimitrov.jpg");
        participantImages.put("Andrey Stankevich", "/seniors/Russia/Russia1/Stankevich_Andrey.jpg");
        participantImages.put("Aleksandra Esenina", "/seniors/Russia/Russia1/Esenina_Aleksandra.jpg");
        participantImages.put("Aleksandr Morozov", "/seniors/Russia/Russia1/Morozov_Aleksandr.jpg");
        participantImages.put("Andrei Efremov", "/seniors/Russia/Russia1/Efremov_Andrei.jpg");
        participantImages.put("Ildar Gainullin", "/seniors/Russia/Russia1/Gainullin_Ildar.jpg");
        participantImages.put("Vladimir Romanov", "/seniors/Russia/Russia1/Romanov_Vladimir.jpg");
        participantImages.put("Alexander Shekhovtsov", "/seniors/Russia/Russia2/Shekhovtsov_Alexander.jpg");
        participantImages.put("Egor Lifar", "/seniors/Russia/Russia2/Lifar_Egor.jpg");
        participantImages.put("Fedor Kuyanov", "/seniors/Russia/Russia2/Kuyanov_Fedor.jpg");
        participantImages.put("Semen Savkin", "/seniors/Russia/Russia2/Savkin_Semen.jpg");
        participantImages.put("Andrei Odintsov", "/seniors/Russia/Russia3/Odintsov_Andrei.jpg");
        participantImages.put("Azat Ismagilov", "/seniors/Russia/Russia3/Ismagilov_Azat.jpg");
        participantImages.put("Savelii Grigorev", "/seniors/Russia/Russia3/Grigorev_Savelii.jpg");
        participantImages.put("Svetlana Shmidt", "/seniors/Russia/Russia3/Shmidt_Svetlana.jpg");
        participantImages.put("Maxim Akhmedov", "/seniors/Russia/Russia3/Akhmedov_Maxim.jpg");
        participantImages.put("Aleksandr Abelyan", "/juniors/Armenia/Abelyan_Aleksandr.jpg");
        participantImages.put("Emil Kostanyan", "/juniors/Armenia/Kostanyan_Emil.jpg");
        participantImages.put("David Margaryan", "/seniors/Armenia/Margaryan_David.jpg");
        participantImages.put("Ediz Haku", "/juniors/Bulgaria/Shumen/Ediz_Bejhan.jpg");
        participantImages.put("Kristian Kozarev", "/juniors/Bulgaria/Shumen/Kristian_Kozarev.jpg");
        participantImages.put("Mihail Vasilev", "/juniors/Bulgaria/Shumen/Mihail_Vasilev.jpg");
        participantImages.put("Rostislav Stoyanov", "/juniors/Bulgaria/Shumen/Rostislav_Stoyanov.jpg");
        participantImages.put("Ivan Stošić", "/seniors/Serbia/Marko_Sisovic.jpg");


        bgTeamNames.put("ROMANIA 1 (National Junior)", "Национален");
        bgTeamNames.put("ROMANIA 2 (ICHB Juniors)", "Букурещ ICHB");
        bgTeamNames.put("Russia 1", "Отбор 1");
        bgTeamNames.put("Russia 2", "Отбор 2");
        bgTeamNames.put("Russia 3", "Отбор 3");
        bgTeamNames.put("Russia 4", "Отбор 4");
        bgTeamNames.put("Russia 5", "Отбор 5");
        bgTeamNames.put("Russia 6", "Отбор 6");
        bgTeamNames.put("BULGARIA - GABROVO", "Габрово");
        bgTeamNames.put("Bulgaria1", "Национален 1");
        bgTeamNames.put("Bulgaria2", "Национален 2");
        bgTeamNames.put("Varna", "Варна");
        bgTeamNames.put("Serbia", "Национален");
        bgTeamNames.put("Azerbaijan #1", "Национален");
        bgTeamNames.put("RОMANIA 4 (Bucharest CNITV)", "CNITV");
        bgTeamNames.put("Sofia", "София");
        bgTeamNames.put("Plovdiv - Gabrovo ", "Пловдив-Габрово");
        bgTeamNames.put("POLAND", "Национален");
        bgTeamNames.put("Armenia", "Национален");
        bgTeamNames.put("Switzerland", "Национален");
        bgTeamNames.put("ROMANIA 3 (Ploiești & Câmpulung Muscel - Seniors)", "Плоещ & Мушчел");
        bgTeamNames.put("ROMANIA 3 (Ploiești & Câmpulung Muscel - Juniors)", "Плоещ & Мушчел");
        bgTeamNames.put("Bulgaria, National-2", "Национален 2");
        bgTeamNames.put("Varna-3", "Варна 3");
        bgTeamNames.put("Varna-1", "Варна 1");
        bgTeamNames.put("Varna-2", "Варна 2");
        bgTeamNames.put("SofiaS1", "София 1");
        bgTeamNames.put("SofiaS2", "София 2");
        bgTeamNames.put("Bulgaria 1", "Национален");
        bgTeamNames.put("Shumen 1", "Шумен");
        bgTeamNames.put("ROMANIA 1 (National Seniors)", "Национален");
        bgTeamNames.put("ROMANIA 2 (ICHB Seniors)", "ICHB");
        bgTeamNames.put("ROMANIA 4 (Craiova Seniors)", "Крайова");
        bgTeamNames.put("RОMANIA 5 (Bucharest CNITV)", "CNITV");
        bgTeamNames.put("Plovdiv - Yambol", "Пловдив - Ямбол");
        bgTeamNames.put("Ruse", "Русе");
        bgTeamNames.put("Shumen 2", "Шумен");

        enTeamNames.put("ROMANIA 1 (National Junior)", "National");
        enTeamNames.put("ROMANIA 2 (ICHB Juniors)", "Bucharest ICHB");
        enTeamNames.put("ROMANIA 3 (Ploiești & Câmpulung Muscel - Juniors)", "Ploiești & Câmpulung Muscel");
        enTeamNames.put("Russia 1", "Team 1");
        enTeamNames.put("Russia 2", "Team 2");
        enTeamNames.put("Russia 3", "Team 3");
        enTeamNames.put("Russia 4", "Team 4");
        enTeamNames.put("Russia 5", "Team 5");
        enTeamNames.put("Russia 6", "Team 6");
        enTeamNames.put("BULGARIA - GABROVO", "Gabrovo");
        enTeamNames.put("Bulgaria1", "National 1");
        enTeamNames.put("Bulgaria2", "National 2");
        enTeamNames.put("Azerbaijan #1", "National");
        enTeamNames.put("RОMANIA 4 (Bucharest CNITV)", "CNITV");
        enTeamNames.put("POLAND", "National");
        enTeamNames.put("Armenia", "National");
        enTeamNames.put("Serbia", "National");
        enTeamNames.put("Bulgaria, National-2", "National 2");
        enTeamNames.put("Varna-3", "Varna 3");
        enTeamNames.put("Varna-1", "Varna 1");
        enTeamNames.put("Varna-2", "Varna 2");
        enTeamNames.put("SofiaS1", "Sofia 1");
        enTeamNames.put("SofiaS2", "Sofia 2");
        enTeamNames.put("Bulgaria 1", "National");
        enTeamNames.put("Shumen 1", "Shumen");
        enTeamNames.put("ROMANIA 1 (National Seniors)", "National");
        enTeamNames.put("ROMANIA 2 (ICHB Seniors)", "ICHB");
        enTeamNames.put("ROMANIA 3 (Ploiești & Câmpulung Muscel - Seniors)", "Ploiești & Câmpulung Muscel");
        enTeamNames.put("ROMANIA 4 (Craiova Seniors)", "Craiova");
        enTeamNames.put("RОMANIA 5 (Bucharest CNITV)", "Bucharest CNITV");
        enTeamNames.put("Switzerland", "National");
        enTeamNames.put("Shumen 2", "Shumen");

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
    public static final String TEAMS_FILE = "./results/teams.xlsx";

    public static final String TL_EN_TITLE = "team leader";
    public static final String DEPTL_EN_TITLE = "deputy leader";
    public static final String CONTESTANT_EN_TITLE = "contestant";

    public static final String TL_BG_TITLE = "ръководител";
    public static final String DEPTL_BG_TITLE = "зам. ръководител";
    public static final String CONTESTANT_BG_TITLE = "състезател";
}
