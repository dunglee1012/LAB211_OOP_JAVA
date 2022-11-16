
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Asus
 */
public class GetInput {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int num;
                num = Integer.parseInt(in.readLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (str.matches(regex)) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println("IOException");
            }
            System.out.println(err);
        }
    }

    public static Double getDouble(String msg, String err, double min, double max) {
        while (true) {
            try {
                System.out.println(msg);
                double num;
                String str = in.readLine();
                num = Double.parseDouble(str);
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange[" + min + "-" + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static Date getDate(String msg, String err, String format) {
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();

                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                Date date = sdf.parse(str);
                return date;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    public String GetTaskType(String msg) {
        int tasktypeID = getInt(msg, "Task Type must be in range[1-4]", 1, 4);
        String result = "";
        switch (tasktypeID) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;
    }

}
