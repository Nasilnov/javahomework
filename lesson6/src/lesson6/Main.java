package lesson6;

import java.io.*;
import java.net.SocketOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException  {

        FileInputStream fis1 = new FileInputStream("c:/temp/file1.txt");
        FileInputStream fis2 = new FileInputStream("c:/temp/file2.txt");
        FileOutputStream fos = new FileOutputStream("c:/temp/result.txt");


        while (fis1.available() > 0) {
            int data = fis1.read();
            fos.write(data);
        }
        fis1.close();

        while (fis2.available() > 0) {
            int data = fis2.read();
            fos.write(data);
        }
        fis2.close();
        fos.close();


        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();


        File dir = new File("c:/temp");
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

        for (int i = 0; i < files.length; i++ ) {
            checkWordInFile(files[i].toString(), word);
        }

    }
    public static void checkWordInFile (String file, String word) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file),"Cp1251"));
        String line;

        while ((line = bf.readLine()) != null) {
            if (line.contains(word)) {
                System.out.println("Слово \"" + word + "\" содержится в файле " + file);
                break;
            }
            else {
                System.out.println("Слово \"" + word + "\" не содержится в файле " + file);
            }
        }
        bf.close();
    }

}
