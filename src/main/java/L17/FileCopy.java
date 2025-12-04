package L17;

import java.io.*;
import java.util.Scanner;


/* Um welchen Faktor (bzw. um wie viel Prozent) unterscheidet sich der Zeitaufwand bei den drei Fällen?
- Der Zeitaufwand für den ungepufferten Stream ist 102.92-mal länger als der für den gepufferten Stream.
- Der Zeitaufwand für den ungepufferten Stream ist 741-mal länger als der für den Byte-Array-Stream.
- Der Zeitaufwand für den gepufferten Stream ist 7.2-mal länger als der für den Byte-Array-Stream.

Um eine genauere Aussage treffen zu können, führen Sie die Messungen zehnmal am Stück durch.
1: 3705, 36, 5      6: 3724, 36, 5      durchschnitt Unbuffered:    3736ms      zu 36ms:104x schneller → 99,03% weniger Zeit | 747x schneller → 99,87% weniger Zeit
2: 3680, 37, 5      7: 3818, 36, 4      durchschnitt Buffered:      36ms
3: 3753, 35, 5      8: 3721, 36, 4      durchschnitt BufferedArray: 5ms
4: 3723, 37, 5      9: 3755, 37, 5
5: 3720, 37, 5      10: 3756, 35, 5



 */
public class FileCopy {
    public static void copyUnbuffered(String input, String output) throws IOException {
        try(
                InputStream fis = new FileInputStream(input);
                OutputStream fos = new FileOutputStream(output)){
            int reader;
            while((reader = fis.read())!= -1){
                fos.write(reader);}}}

    public static void copyBuffered(String input, String output) throws IOException{
        try(
        InputStream bis = new BufferedInputStream(new FileInputStream(input));
        OutputStream bos = new BufferedOutputStream(new FileOutputStream(output))){
            int reader;
            while((reader = bis.read())!= -1){
                bos.write(reader);}
        bos.flush();}}

        public static void copyBufferedWithByteArray(String input, String output) throws IOException {
            try(
                    InputStream fis = new FileInputStream(input);
                    OutputStream fos = new FileOutputStream(output)){
                byte[] buffer = new byte[1024];
                int reader;
                while((reader = fis.read(buffer))!= -1){
                    fos.write(buffer, 0, reader);}}}

public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Bitte Pfad eingeben: ");
//        String inputPath = sc.nextLine();
		String inputPath = "./target/test.mp3";
        String outputPath = "kopierte_musik.mp3";

        try{
            long startTime = System.currentTimeMillis();
            copyUnbuffered(inputPath,outputPath);
            long endTime = System.currentTimeMillis();
            System.out.println("Unbuffered dauerte: " + (endTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            copyBuffered(inputPath,outputPath);
            endTime = System.currentTimeMillis();
            System.out.println("Buffered dauerte: " + (endTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            copyBufferedWithByteArray(inputPath,outputPath);
            endTime = System.currentTimeMillis();
            System.out.println("BufferedArray dauerte: " + (endTime - startTime) + " ms");

            File original = new File(inputPath);
            File copy = new File(outputPath);
            if (original.length() == copy.length()){
                System.out.println("Die Dateien haben die gleiche Größe");}
                else System.out.println("Die Dateien haben NICHT die gleiche Größe");
            }
        catch(FileNotFoundException e){
            System.out.println("Fehler: datei wurde nicht gefunden");
        }
        catch(IOException e){
            System.out.println("Fehler beim kopieren der Datei");
        }

    }
}
