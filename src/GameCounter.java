import Hand.Card;
import Worker.Analyzer;

import java.util.ArrayList;
import java.util.List;

public class GameCounter {
    public static void main(String argv[]) {
        Analyzer analyzer = new Analyzer();

        List<List<Card>> testCards = new ArrayList<>();
        List<Card> player1 = new ArrayList<Card>();
        player1.add(new Card(0));
        player1.add(new Card(13));

        List<Card> player2 = new ArrayList<Card>();
        player2.add(new Card(12));
        player2.add(new Card(25));

        testCards.add(player1);
        testCards.add(player2);

        double test = analyzer.preFlopWinRate(2, testCards);
        System.out.println(test);
    }
}
