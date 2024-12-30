package cards;

public class Card {
    private String name;
    private String rarity;
    private String clan;
    private int count;

    public Card(String name, String rarity, String clan, int count) {
        this.name = name;
        this.rarity = rarity;
        this.clan = clan;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public String getRarity() {
        return rarity;
    }

    public String getClan() {
        return clan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public void increaseCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return "\n" + "Nome: " + this.name + " x" + this.count + "\n";
        // + "Clan: " + this.clan + "\n"
        // + "Quantidade: " + this.count + "\n"
        // + "Raridade: " + this.rarity + "\n";
    }
}
