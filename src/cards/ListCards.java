package cards;

import java.util.ArrayList;

public class ListCards {
    private ArrayList<Card> listCards;

    public ListCards() {
        listCards = new ArrayList<>();
    }

    public int size() {
        return listCards.size();
    }

    public String getCardName(String name) {
        if (getCard(name) != null)
            return getCard(name) + "\n";
        return "null";
    }

    public Boolean searchCard(String name) {
        for (Card c : listCards) {
            if (c.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void increaseCount(String name) {
        if (searchCard(name)) {
            System.out.println("aumentou em");
            getCard(name).increaseCount();
        }
    }

    public void addCard(Card c) {
        listCards.add(c);
    }

    @Override
    public String toString() {
        String teste = "";
        int count = 0;
        while (count < listCards.size()) {
            teste += listCards.get(count) + "\n";
            count++;
        }
        return teste;
    }

    public Boolean isEmpty() {
        return listCards.isEmpty();
    }

    private Card getCard(String name) {
        for (Card c : listCards) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
}
