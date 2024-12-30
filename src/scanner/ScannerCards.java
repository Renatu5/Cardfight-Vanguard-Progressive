package scanner;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import cards.Card;
import cards.ListCards;

public class ScannerCards {
    private Path input;
    private Path output;

    public void WriteCards(Path o, ListCards listCards) {
        this.output = o;
        System.out.println(listCards.size());
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(output, StandardCharsets.UTF_8))) {
            int count = 0;
            while (count <= listCards.size()) {
                writer.write(listCards.toString());
                count++;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void testeAddCard(ListCards listCards) {
        System.out.println(listCards.size());
        listCards.addCard(new Card("Zorga", "RRR", "Stoicheia", 1));
        System.out.println(listCards.size());
    }

    public ListCards readCards(Path i, ListCards listCards) {
        this.input = i;
        String line = "";
        try (BufferedReader reader = Files.newBufferedReader(input)) {
            while ((line = reader.readLine()) != null) {
                String name = reader.readLine();
                String clan = reader.readLine();
                reader.readLine();
                String rarity = reader.readLine();
                if (listCards.searchCard(name)) {
                    listCards.increaseCount(name);
                } else {
                    Card newCard = new Card(name, rarity, clan, 1);
                    listCards.addCard(newCard);
                }
                reader.readLine();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println(listCards.size());
        return listCards;
    }
}
