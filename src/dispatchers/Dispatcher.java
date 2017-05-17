package dispatchers;

import models.ConsoleHelper;
import utils.ListUtils;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator1 on 17.05.2017.
 */
public class Dispatcher {
    public static void main(String[] args) throws Exception {
        //Timer
        Date sdate;  //start timer val
        long edate;  //end timer val
        long ldate;  //end and start diff

        //Выводим список вопросы по очереди
        ArrayList<String> list = ListUtils.genList(16);

        //Статистика
        int answ = -1, x, y, z, e = 0;
        char[] vals;
        char o;

        //Are you ready?
        System.out.println("Are you ready? (y/n)");
        String waiter = ConsoleHelper.readWords();

        if (waiter.equals("y") || waiter.equals("yes")) {

            System.out.println("Time Start!");

            sdate = new Date();
            //для каждого значения в списке выполнить метода anw
            for (int i = 0; i < list.size(); i++) {

                vals = (list.get(i).toCharArray());
                x = Character.getNumericValue(vals[0]);
                y = Character.getNumericValue(vals[2]);

                o = vals[1];
                z = x * y - x - y;

                switch (o){
                    case '+': z = x + y; break;
                    case '*': z = x * y; break;
                    case '/': z = x / y; break;
                    case '-': z = x - y; break;
                }

                System.out.println(list.get(i));
                answ = Integer.parseInt( ConsoleHelper.readWords());
                if (answ == z) {
                    System.out.println("ok, answer is: " + z + " next...");
                }
                if (answ != z) {
                    System.out.println("bad... one more time..");
                    e++;
                    i = i - 1;
                }
            }

            if (answ == -1) {
                System.out.println("e");
            }
            edate = new Date().getTime();
            ldate = edate - sdate.getTime();
            ConsoleHelper.printWin(sdate, edate, ldate, e);

        }

        if (waiter.equals("n") || waiter.equals("no")) {
            System.out.println("What you want?");
            waiter = ConsoleHelper.readWords();
            if (waiter.equals("generate")) {
                ListUtils.saveList();
            }
            if (waiter.equals("read")) {
                list = ListUtils.readList();

                for (String str : list) {

                    System.out.println(str);
                }
            }
            if (waiter.equals("stat")) {
                System.out.println("What you want do?[last, best, top]");
                if (waiter.equals("read")) {
                    System.out.println("This is stat");
                }

            }

        }
    }
}
