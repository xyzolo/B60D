import model.ConsoleHelper;
import model.examles.TextExampl;
import model.example_generators.TextExamplesGenerator;
import model.record_worker.ConectorToBd;
import model.workers.WorkerWithTextExamples;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator1 on 17.05.2017.
 */
public class TestO1 {

    public static void main(String[] args) throws InterruptedException {
        WorkerWithTextExamples workerWithTextExamples = new WorkerWithTextExamples();
        Date startDate = new Date();
        Thread.sleep(15000);
//        System.out.println(workerWithTextExamples.considersPoints(6, startDate, new Date()));
    }
    public static void main3(String[] args) {
        ConectorToBd  conectorToBd = new ConectorToBd();
        System.out.println(conectorToBd.signUp("dir3","1234"));
        System.out.println(conectorToBd.logIn("dir3", "1234"));
        conectorToBd.writeRecords(1024);
        conectorToBd.closeConection();
    }//


    public static void main2(String[] args) throws IOException {
        TextExamplesGenerator generator = new TextExamplesGenerator("D:\\tests2\\B60D\\src\\ExamplesTest");
        List<TextExampl> list = generator.getReadingExamples();
        for (TextExampl textExampl : list) {
            System.out.println(textExampl + " \n\n");
        }
        for (TextExampl textExampl : list) {
            System.out.println(textExampl.testAnswer(ConsoleHelper.readString()));
        }
    }
    public static void main1(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://mysql.alex-savin.myjino.ru:3306/alex-savin_trutak","046470945_RutaK", "2017!RutaK"
        );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users1");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getInt("id") + "\n");
        }
        resultSet.close();

//        statement.executeUpdate(
//                "INSERT INTO users1(name, date) VALUES ('grgr', CURRENT_DATE);");

        statement.executeUpdate("UPDATE users1 SET date = CURRENT_DATE WHERE id > 3 AND id <= 7");
        statement.executeUpdate("DELETE FROM users1 WHERE id > 8");

        resultSet = statement.executeQuery("SELECT * FROM users1");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getInt("id") + "\n");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
