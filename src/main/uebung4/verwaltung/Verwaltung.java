package main.uebung4.verwaltung;

import main.uebung4.userstory.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Verwaltung {

    private static List<UserStory> liste = new ArrayList<>();

    private static List<Task> taskListe = new ArrayList<>();

    private static Scanner einscannen = new Scanner(System.in);



    public static void verwalten() throws IOException, ClassNotFoundException {
        System.out.println("wählen sie einen der folgenenden Befehle\n" +
                "story (Eingabe einer User Story ohne Tasks)\n" +
                "task (Eingabe eines Tasks ohne Zuordnung zu User Story)\n" +
                "assign (Zuordung einer Task-ID zu einer User-ID)\n" +
                "stories (Ausgabe aller gespeicherten User Stories mit Tasks)\n" +
                "tasks (Ausgabe aller gespeicherten Tasks)\n" +
                "load (Laden der gespeicherten User Stories aus einer Datei)\n" +
                "save (Speichern der eingegebenen User Stories in einer Datei)\n");

        while (einscannen.hasNext()) {
            String scan = einscannen.next();

            if(scan.equals("story")) {
                int id = einscannen.nextInt();
                String bschr = "";
                String start = einscannen.next();
                bschr += start.substring(1);

                while (einscannen.hasNext()) {
                    if (bschr.charAt(bschr.length()-1) == '"') {
                        bschr = bschr.substring(0, bschr.length()-1);
                        break;
                    }

                    String s = einscannen.next();

                    if (s.charAt(s.length()-1) == '"'){
                        bschr+= " " + s.substring(0, s.length()-1);
                        break;
                    }else{
                        bschr+= " " + s;
                    }
                }

                String moscow = einscannen.next();


                liste.add(new UserStory(id, bschr, moscow));
                continue;
            } else if (scan.equals("task")) {
                int id = einscannen.nextInt();
                String bschr = "";
                String start = einscannen.next();
                bschr += start.substring(1);

                while (einscannen.hasNext()) {
                    if (bschr.charAt(bschr.length()-1) == '"') {
                        bschr = bschr.substring(0, bschr.length()-1);
                        break;
                    }

                    String s = einscannen.next();

                    if (s.charAt(s.length()-1) == '"'){
                        bschr+= " " + s.substring(0, s.length()-1);
                        break;
                    }else{
                        bschr+= " " + s;
                    }
                }

                taskListe.add(new Task(id, bschr));
                continue;
            } else if (scan.equals("assign")) {
                boolean test = false;
                int userID = einscannen.nextInt();
                int taskID = einscannen.nextInt();

                for (int i=0; i<taskListe.size(); i++){
                    if(taskListe.get(i).getId()== taskID){
                        test = true;
                        for(int j=0; j<liste.size(); j++){
                            if(liste.get(j).getId()== userID){
                                liste.get(j).addTask(taskListe.get(i));
                                break;
                            } else if(i== liste.size()-1){
                                System.out.println("Keine User Story mit ID " + userID + " enthalten!");
                            }
                        }

                        break;
                    }
                }

                if (!test) {
                    System.out.println("Keine Task mit ID " + taskID + " enthalten!");
                    continue;
                }
                System.out.println("Task mit ID " + taskID + " wurde erfolgreich User Story mit ID " + userID + " zugeordnet.");

            } else if (scan.equals("stories")) {
                System.out.println("Die folgenden User Stories sind im System gespeichert:");
                for(int i=0; i< liste.size(); i++){
                    System.out.println(liste.get(i).toString());
                }
                continue;
            } else if (scan.equals("tasks")) {
                System.out.println("Die folgenden Tasks sind im System gespeichert:");
                for(int i=0; i< taskListe.size(); i++){
                    System.out.println(taskListe.get(i).toString());
                }
                continue;
            } else if (scan.equals("save")) {
                if (liste.isEmpty())
                    continue;

                FileOutputStream fout = new FileOutputStream("src/main/uebung4/userstory/file.txt");
                ObjectOutputStream oot = new ObjectOutputStream(fout);

                oot.writeObject(liste);

                oot.flush();

                oot.close();

                liste.clear();

                continue;
            } else if (scan.equals("load")) {
                FileInputStream fin = new FileInputStream("src/main/uebung4/userstory/file.txt");
                ObjectInputStream oin = new ObjectInputStream(fin);

                liste.addAll((Collection<? extends UserStory>) oin.readObject());

                continue;
            } else if (scan.equals("exit")) {
                break;
            }
        }

        System.out.println("Scan vorgang beendet!");

    }

    public static void main(String[] args) {
        // Testen der Gesamt Applikation über Main Methode


        try {
            verwalten();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
