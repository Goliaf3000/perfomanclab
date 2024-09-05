import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class foure {
    public static void main(String[] args) throws FileNotFoundException {
        int  ocrug, c = 0;
        double srednie = 0;
        String line = "";
        File file1 = new File(args[0]);
        Scanner scan = new Scanner(file1);
        while (scan.hasNextLine()) {
            line += scan.nextLine();
            line = line.replace(" ", ",");
        }
        String[] words1 = (line.split(","));
        Integer[] words = Stream.of(words1).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        for (int i : words) {
            srednie += i;
        }
        srednie /= words.length;
        ocrug = words[0];
        for (int i : words) {
            if (Math.abs(srednie - i) < Math.abs(srednie - ocrug)) ocrug = i;
        }
        outerLoop:
        while (true) {
            for (int mas = 0; mas < words.length; mas++) {
                if (words[mas] < ocrug) {
                    words[mas] = words[mas] + 1;
                    break;

                } else if (words[mas] > ocrug) {
                    words[mas] = words[mas] - 1;
                    break;
                }
                else if (mas == words.length-1) break outerLoop;
            }
            c++;
        }
        System.out.println(c);
        System.out.println(Arrays.asList(words));
    }
}
