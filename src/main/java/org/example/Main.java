package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // contenido del fichero "ABCDEFGH"
            System.out.println("Contenido del fichero inicial es ABCDEFGH");
            String filePath = "source.txt";
            byte[] charsLeidos = leeCharsDelFichero(filePath, 1, 5);
            System.out.println("Caracteres leídos desde posición 1 a la 5");
            System.out.println(new String(charsLeidos));

            System.out.println("Escribiendo \"dato\" en posición 5");
            escribeDato(filePath, "dato", 5);
            //"El contenido del fichero ahora es "ABCDEdato"
            System.out.println("El contenido del fichero ahora es \"ABCDEdato\"");

            System.out.println("Añadiendo al final del fichero \"añadido\"");
            escribeAlFinal(filePath, "añadido");
            //Ahora el contenido del fichero es "ABCDEdatoañadido"
            System.out.println("Ahora el contenido del fichero es \"ABCDEdatoañadido\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escribeAlFinal(String filePath, String data) throws IOException {
        RandomAccessFile raFile = new RandomAccessFile(filePath, "rw");
        raFile.seek(raFile.length());
        System.out.println("posición actual = " + raFile.getFilePointer());
        raFile.write(data.getBytes());
        raFile.close();

    }

    private static void escribeDato(String filePath, String data, int seek) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(seek);
        file.write(data.getBytes());
        file.close();
    }

    private static byte[] leeCharsDelFichero(String filePath, int seek, int chars) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(seek);
        byte[] bytes = new byte[chars];
        file.read(bytes);
        file.close();
        return bytes;
    }
}
