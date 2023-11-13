import java.util.*;

public class Spiel {
    public static void main(String[] args) throws IllegalAccessException {

        //Scanner
        Scanner scanner = new Scanner(System.in);

        //Anzahl der Spieler abfragen
        System.out.print("Anzahl der Spieler: ");
        int anzahlSpieler = scanner.nextInt();
        scanner.nextLine();

        //Array für Spieler erstellen
        //String[] spieler = new String[anzahlSpieler];

        //Map erstellen
        Map<String, Kartendeck> spielerDeck = new HashMap<>();

        //Kartendeck gesamt
        ArrayList<Spielkarte> gesamt = Kartendeck.kartendeck;

        //Kartendeck mischen
        Kartendeck.kartenMischen(gesamt);

        //Variablen erstellen und Array verkürzen
        int kartenProSpieler = gesamt.size() / anzahlSpieler;
        int extraKarten = gesamt.size() % anzahlSpieler;
        for (int i = 0; i < extraKarten; i++) {
            gesamt.remove(i);
        }
        System.out.println("Karten pro Spieler: " + kartenProSpieler);
        scanner.nextLine();

        //Spieler Namen ins array eingeben
        for (int i = 0; i < anzahlSpieler; i++) {
            System.out.print("Spieler " + (i + 1) + " bitte Namen angeben: ");
            String spielerName = scanner.nextLine();

            //An die Spieler Karten austeilen
            ArrayList<Spielkarte> spielerKarten = new ArrayList<>();
            for (int j = i * gesamt.size() / anzahlSpieler; j < (i + 1) * gesamt.size() / anzahlSpieler; j++) {
                spielerKarten.add(gesamt.get(j));
            }
            Kartendeck playerCards = new Kartendeck(spielerKarten);
            spielerDeck.put(spielerName, playerCards);
        }

        System.out.println();
        boolean spielBeendet = true;
        System.out.print("Spiel starten (ja/nein)? ");
        char c = scanner.next().charAt(0);
        if (c == 'j') {
            spielBeendet = false;
        }
        scanner.nextLine();


        //Runden system

        int runde = 1;

        while (!spielBeendet) {
            System.out.println("Runde " + runde + ":");
            scanner.nextLine();

            //1. Spieler an der Reihe ermitteln
            for (String spieler : spielerDeck.keySet()) {
                if (spielerDeck.get(spieler).getKarten().isEmpty()) {
                    continue; // Skip this player if the deck is null
                }
                System.out.println(spieler + " deine oberste Karte ist:");
                scanner.nextLine();

                //2. Attribute dessen Karte anzeigen
                Spielkarte obersteKarte = spielerDeck.get(spieler).getKarten().getFirst();
                obersteKarte.printCard();
                scanner.nextLine();

                //3. Spieler eine Auswahl treffen lassen
                System.out.print("Wähle dein Attribut: ");
                String attribute = scanner.nextLine();
                scanner.nextLine();

                //4. Die Karten der Anderen aufdecken und in eine ArrayList packen

                ArrayList<Spielkarte> aufgedeckteKarten = new ArrayList<>();
                for (String spielerName : spielerDeck.keySet()) {
                    if (spielerDeck.get(spielerName).getKarten().isEmpty()) {
                        continue;
                    }
                        System.out.println(spielerName + ":");
                        Spielkarte andereKarte = spielerDeck.get(spielerName).getKarten().getFirst();
                        aufgedeckteKarten.add(andereKarte);
                        andereKarte.printCard();
                        scanner.nextLine();
                }

                //5. Den Gewinner bestimmen

                Spielkarte winner = aufgedeckteKarten.get(0);
                for (int k = 1; k < aufgedeckteKarten.size(); k++) {
                    Spielkarte current = aufgedeckteKarten.get(k);
                    if (current.compareTo(winner, attribute) > 0) {
                        winner = current;
                    }
                }
                //6. Karten verteilen
                for (int h = 0; h < aufgedeckteKarten.size(); h++)
                    if (winner == aufgedeckteKarten.get(h)) {

                    int x = 0;
                    for (String player : spielerDeck.keySet()) {
                        if (spielerDeck.get(player).getKarten().isEmpty()){
                            continue;
                        }
                        if (x == h) {
                            spielerDeck.get(player).getKarten().addAll(aufgedeckteKarten);
                            System.out.println("Gewinner: " + player + "!");
                            scanner.nextLine();
                        }
                        spielerDeck.get(player).getKarten().removeFirst();
                        x++;
                    }
                }
                //7. Option um Decks anzusehen:
                System.out.print("Neue Kartenverteilung anzeigen (ja/nein)? ");
                char y = scanner.next().charAt(0);
                System.out.println();
                if (y == 'j') {
                    for (String spielerName : spielerDeck.keySet()) {
                        if (spielerDeck.get(spielerName).getKarten().isEmpty()) {
                            continue;
                        }
                        System.out.println(spielerName + " hat nun ein Kartendeck mit " + spielerDeck.get(spielerName).getKarten().size() + " Karten: ");
                        for (Spielkarte karte : spielerDeck.get(spielerName).getKarten()) {
                            karte.printName();
                        }
                        System.out.println();
                    }
                    scanner.nextLine();
                }


                // 8. Prüfen ob Spieler alle enums gesammelt hat, wenn ja setze "spielBeendet auf 'true'.
                for (String players : spielerDeck.keySet() ) {
                    if (spielerDeck.get(players).getKarten().size() == gesamt.size()) {
                        System.out.println(players + " hat gewonnen! Herzlichen Glückwunsch!");
                        spielBeendet = true;
                    }
                    if (spielerDeck.get(players).getKarten().isEmpty()) {
                        //spielerDeck.remove(players);
                        System.out.println(players + " hat verloren und ist raus!");
                        System.out.println();
                    }
                }
                //


                //Weiter?
                System.out.print("Wollt ihr weiterspielen (ja/nein)? ");
                char q = scanner.next().charAt(0);
                scanner.nextLine();
                if (q == 'n') {
                    spielBeendet = true;
                }

                runde++;


                }
            }
        }
    }

