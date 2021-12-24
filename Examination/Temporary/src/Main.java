import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            // 获取输入数据  2019,12,31,23,59,59,1
            String[] splits = sc.nextLine().split(",");

            String time = splits[0] + "-" + splits[1] + "-" + splits[2] + " " + splits[3] + ":" + splits[4] + ":" + splits[5];
            String addTime = splits[6];

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date parse = format.parse(time);
                long before = parse.getTime();
                long now = before + Integer.valueOf(addTime)*1000;
                Date date = new Date(now);
                System.out.println(format.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
