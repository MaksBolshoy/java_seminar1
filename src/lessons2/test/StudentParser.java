package lessons2.test;

//Дана строка json:
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод, который распарсит этот текст и, используя StringBuilder, создаст строки вида:
//Студент [фамилия] получил [оценка] по предмету [предмет]. Например:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.
public class StudentParser {
    private static String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"математика\"}, {\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"физика\"}]";


    public static void parse() {
        StringBuilder builder = new StringBuilder();
        String[] parts = json.split(",");
        for (String s : parts) {
            if (s.split(":")[0].trim().replaceAll("[\"{}\\[\\]]", "").equals("фамилия")) {
                builder.append("студент ")
                        .append(s.replaceAll("[\"}\\[\\]]", ""))
                        .split(":")[1];
            }
            if (s.split(":")[0].replaceAll("[\"{}\\[\\]]", "").equals("оценка")) {
                builder.append("получил ")
                        .append(s.split(":")[1]
                                .replaceAll("[\"{}\\[\\]]", ""));
            }
            if (s.split(":")[0]
                    .replaceAll("[\"{}\\[\\]]", "").equals("предмет")) {
                builder.append("по предмету ")
                        .append(s.split("")[1]
                                .replaceAll("[\"{}\\[\\]]", "")).append(".\n");

            }

        }
        System.out.println(builder);

    }
}



