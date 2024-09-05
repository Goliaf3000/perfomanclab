package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class two {
    public static void main(String[] args) throws FileNotFoundException {
        String[] words1 = getInt(args[0]);
        String[] words2 = getInt(args[1]);
        RadiusAndPoint(words1,words2);
    }
    public static String[] getInt(String file) throws FileNotFoundException {
        String line = "";
        File file1 = new File(file);
        Scanner scan = new Scanner (file1);
        while (scan.hasNextLine()) {
            line += scan.nextLine();
            line = line.replace(" ", "");
        }
        String[] words = line.split("");
        return words;

}
    public static void RadiusAndPoint(String[] f1, String[] f2){
        if (f2.length < 1 || f2.length > 100) return;
        int x_ocr = Integer.parseInt(f1[0]), y_ocr = Integer.parseInt(f1[1]), rad = Integer.parseInt(f1[2]);
        for (int i = 0; i < f2.length; i+=2) {
            int x = Integer.parseInt(f2[i]), y = Integer.parseInt(f2[i+1]);
            if ((Math.pow((x - x_ocr), 2) + Math.pow((y - y_ocr), 2)) < Math.pow(rad, 2)) System.out.println("1 - точка внутри");
            else if ((Math.pow((x - x_ocr),2) + Math.pow((y - y_ocr),2)) == Math.pow(rad,2)) System.out.println("0 - лежит на окружности");

            else {
                System.out.println("2 - точка снаружи");
            }
        }
    }
}
