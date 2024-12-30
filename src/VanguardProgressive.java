import java.nio.file.Paths;
import java.util.Scanner;

import cards.ListCards;
import scanner.ScannerCards;

public class VanguardProgressive {
    private ListCards ld = new ListCards();
    private ScannerCards scannerCards = new ScannerCards();

    public void execute() throws Exception {
        int selected;
        Scanner sc = new Scanner(System.in);
        try {
            do {
                System.out.println("Cardfight Vanguard Progressive Database");
                System.out.println("1 - Ler arquivo(.txt)");
                System.out.println("2 - listar cartas");
                System.out.println("3 - exportar dados");
                System.out.println("4 - sair");
                selected = sc.nextInt();
                switch (selected) {
                    case 1:
                        readFile();
                        break;
                    case 2:
                        listAllCards();
                        break;
                    case 3:
                        exportCards();
                        break;
                    case 99:
                        testeCard();
                    default:
                        break;
                }
            } while (selected != 4);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void readFile() {
        Scanner sc = new Scanner(System.in);
        String file;
        System.out.println("qual o nome do arquivo? (sem o formato)");
        file = sc.nextLine();
        // System.out.println(file);
        scannerCards.readCards(Paths.get(file + ".txt"), ld);
    }

    public void listAllCards() throws Exception {
        if (ld.isEmpty()) {
            throw new Exception("Lista está vazia");
        }
        int count = 0;
        while (count <= ld.size()) {
            System.out.println(ld.toString());
            count++;
        }
    }

    public void exportCards() {
        if (ld.isEmpty()) {
            System.out.println("Lista Vazia");
            return;
        }
        String file;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do Arquivo");
        file = sc.nextLine() + ".txt";
        scannerCards.WriteCards(Paths.get(file), ld);
    }

    public void testeCard() {
        scannerCards.testeAddCard(ld);
    }
}
