import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;
import java.util.ArrayList;

public class Kartendeck {
    static ArrayList<Spielkarte> kartendeck = new ArrayList<>(EnumSet.allOf(Spielkarte.class));
    private ArrayList<Spielkarte> karten;

    public Kartendeck(ArrayList<Spielkarte> karten) {
        this.karten = karten;
    }

    public static void kartenMischen(ArrayList<Spielkarte> kartendeck) {
        Random random = new Random();
        Collections.shuffle(kartendeck, random);    // Die Elemente in kartendeckList werden gemischt
    }

    public static void kartenSortieren(ArrayList<Spielkarte> kartendeck) {
        Collections.sort(kartendeck);
    }
    public ArrayList<Spielkarte> getKarten() {
        return karten;
    }
}


