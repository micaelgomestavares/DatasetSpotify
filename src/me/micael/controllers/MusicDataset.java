package src.me.micael.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import src.me.micael.interfaces.MusicCollection;
import src.me.micael.model.Music;

public class MusicDataset {

    public static void readDefaultDataset(String datasetPath, MusicCollection musicColection) {

        try {
            BufferedReader readBuffer = new BufferedReader(new FileReader(datasetPath));
            String readLine;

            while ((readLine = readBuffer.readLine()) != null) {
                String[] actualLine = splitLineWithQuotes(readLine);

                if (!verifyLine(actualLine)) {

                    Music music = new Music(actualLine[0], actualLine[1], actualLine[4], actualLine[5],
                            actualLine[13], actualLine[16], actualLine[17]);

                    musicColection.addMusic(music);
                }
            }

            readBuffer.close();
        } catch (IOException e) {
            System.out.println("Não consegui ler o arquivo");
        } catch (NullPointerException e) {
            System.out.println("Linha nula");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Algum índice é nulo");
        }
    }

    public static void writeDataset(String datasetPath, MusicCollection musicColection) {

        try {
            FileWriter writeOnArchive = new FileWriter(datasetPath);

            for (int i = 0; i < musicColection.getTotalNumberOfMusics(); i++) {
                Music music = musicColection.getMusic(i);

                writeOnArchive.write(music.getArtist() + ",");
                writeOnArchive.write(music.getTrack() + ",");
                writeOnArchive.write(music.getDanceability() + ",");
                writeOnArchive.write(music.getEnergy() + ",");
                writeOnArchive.write(music.getDuration_min() + ",");
                writeOnArchive.write(music.getViews() + ",");
                writeOnArchive.write(music.getLikes());
                writeOnArchive.write("\n");
            }

            writeOnArchive.flush();
            writeOnArchive.close();

        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } catch (NullPointerException e) {
            System.out.println("Música nula, não foi possível obter a informação");
        }

    }

    private static String[] splitLineWithQuotes(String line) {
        ArrayList<String> parts = new ArrayList<>();
        StringBuilder currentPart = new StringBuilder();
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                insideQuotes = !insideQuotes;
            } else if (c == ',' && !insideQuotes) {
                /*
                 * Caso for uma vírgula, porém não estamos dentro de aspas duplas, ele adiciona
                 * esta parte
                 * e reseta o string builder.
                 */
                parts.add(currentPart.toString());
                currentPart.setLength(0);
            } else if (c == ',' && insideQuotes) {
                /*
                 * Ignorar vírgulas dentro das aspas.
                 */
            } else {
                /*
                 * Se não estivermos dentro de aspas duplas, e o caractere atual não é uma
                 * vírgula, apenas adicionamos
                 * ao string builder.
                 */
                currentPart.append(c);
            }
        }

        parts.add(currentPart.toString());

        return parts.toArray(new String[0]);
    }

    private static boolean verifyLine(String actualLine[]) throws ArrayIndexOutOfBoundsException {

        int[] indicesToCheck = { 0, 1, 4, 5, 13, 16, 17 };

        for (int index : indicesToCheck) {
            if (actualLine[index].isEmpty() || actualLine[index].equalsIgnoreCase("0.0") || actualLine[index] == null) {
                return true;
            }
        }
        return false;

    }

    public static void listAllMusics(MusicCollection musicColection) {

        if (musicColection.getTotalNumberOfMusics() == 0) {
            System.out.println("A lista está vazia");
        }

        for (int i = 0; i < musicColection.getTotalNumberOfMusics(); i++) {

            Music music = musicColection.getMusic(i);
            System.out.println("*---------------------*");
            System.out.println("Artista: " + music.getArtist());
            System.out.println("Nome da Musica: " + music.getTrack());
            System.out.println("Danceability: " + music.getDanceability());
            System.out.println("Energy: " + music.getEnergy());
            System.out.println("Duration: " + music.getDuration_min());
            System.out.println("Likes: " + music.getLikes());
            System.out.println("Views: " + music.getViews());
            System.out.println("*---------------------*");
            System.out.print("\n");
        }

    }
}
