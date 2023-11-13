import java.util.Random;

public enum Spielkarte {
    KÖNIGSCOBRA("Königskobra", 5.3, 4, 80, 5, 15),
    ANACONDA("Anakonda", 9.1, 250, 0, 3, 11),
    INLANDTAIPAN("Inlandtaipan", 2.5, 5, 100, 6, 12),
    SCHWARZEMAMBA("Schwarze Mamba", 4.5, 2, 95, 4, 16),
    NETZPYTHON("Netzpython", 10, 75, 3, 7, 5),
    TODESOTTER("Todesotter", 1.5, 1, 85, 16, 10),
    GABOONVIPER("Gabunviper", 1.7, 10, 70, 15, 9),
    KLAPPERSCHLANGE("Klapperschlange", 2.1, 3.5, 60, 14, 13),
    BOACONSTRICTOR("Boa Constrictor", 2.4, 15, 2, 12, 3),
    EIERSCHLANGE("Eierschlange", 1.1, 0.6, 1, 8, 1),
    GRÜNE_BAUMPYTHON("Grüne Baumpython", 1.8, 1.7, 4, 13, 7),
    KREUZOTTER("Kreuzotter", 0.7, 0.8, 30, 10, 6),
    RINGELNATTER("Ringelnatter", 1.2, 1.1, 5, 11, 2),
    SCHWARZE_COBRA("Schwarze Kobra", 1.3, 1.9, 75, 9, 14),
    OLIV_SEESCHLANGE("Oliv-Seeschlange", 1.6, 0.7, 90, 1, 4),
    GELBBAUCH_SEESCHLANGE("Gelbbauch-Seeschlange", 1.4, 0.5, 97, 2, 8),
    ;

    private String name;
    private double length;
    private double weight;
    private int venom;
    private int camo;
    private int agression;

    Spielkarte(String name, double length, double weight, int venom, int camo, int agression) {
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.venom = venom;
        this.camo = camo;
        this.agression = agression;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public int getVenom() {
        return venom;
    }

    public int getCamo() {
        return camo;
    }

    public int getAgression() {
        return agression;
    }

    //Methoden
    public void printName() {
        System.out.println("Name: " + name);
    }
    public void printCard() {
        System.out.println("Name: " + name);
        System.out.println("Länge: " + length + " m");
        System.out.println("Gewicht: " + weight + " kg");
        System.out.println("Gift: " + venom);
        System.out.println("Tarnung: " + camo);
        System.out.println("Agression: " + agression);
    }

    public int compareTo(Spielkarte name, String attribute) throws IllegalAccessException {
        switch (attribute) {
            case "Länge":
                if (this.getLength() > name.getLength()) {
                    return +1;
                }
                if (this.getLength() < name.getLength()) {
                    return -1;
                }
                if (this.getLength() == name.getLength()) {
                    return 0;
                }
                ;
            case "Gewicht":
                if (this.getWeight() > name.getWeight()) {
                    return +1;
                }
                if (this.getWeight() < name.getWeight()) {
                    return -1;
                }
                if (this.getWeight() == name.getWeight()) {
                    return 0;
                }
                ;
            case "Gift":
                if (this.getVenom() > name.getVenom()) {
                    return +1;
                }
                if (this.getVenom() < name.getVenom()) {
                    return -1;
                }
                if (this.getVenom() == name.getVenom()) {
                    return 0;
                }
                ;
            case "Tarnung":
                if (this.getCamo() > name.getCamo()) {
                    return +1;
                }
                if (this.getCamo() < name.getCamo()) {
                    return -1;
                }
                if (this.getCamo() == name.getCamo()) {
                    return 0;
                }
                ;
            case "Agression":
                if (this.getAgression() > name.getAgression()) {
                    return +1;
                }
                if (this.getAgression() < name.getAgression()) {
                    return -1;
                }
                if (this.getAgression() == name.getAgression()) {
                    return 0;
                }
                ;
            default:
                throw new IllegalAccessException("Ungültiges Attribut: " + attribute);


        }
    }
}
