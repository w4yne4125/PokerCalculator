package Worker;

import Hand.Card;
import Hand.HandValue;

import java.util.*;

public class Analyzer {

    Judge judge;
    int[] curWinTimes;

    public Analyzer() {
        this.judge = new Judge();
    }

    private HandValue bestValueOfSeven(List<Card> cards) {
        int[] idx = new int[5];
        HandValue bestHand = null;
        for (int i = 0; i < 5; i++) {
            idx[i] = i;
        }
        while (idx[4] < 7) {
            // Do things on idx
            HandValue thisHand = judge.judgeHandValue(new Card[]{cards.get(idx[0]),
                                                                cards.get(idx[1]),
                                                                cards.get(idx[2]),
                                                                cards.get(idx[3]),
                                                                cards.get(idx[4])});
            if (bestHand == null || thisHand.CompareTo(bestHand) == 1) {
                bestHand = thisHand;
            }

            // generate next idx in lexicographic order
            int t = 4;
            while (t != 0 && idx[t] == 2 + t) {
                t--;
            }
            idx[t]++;
            for (int i = t + 1; i < 5; i++) {
                idx[i] = idx[i - 1] + 1;
            }
        }
        return bestHand;
    }

    private int getWinner(int playersNum, List<List<Card>> hands, List<Card> community) {
        List<HandValue> bestOfAllPlayers = new ArrayList<>(playersNum);

        ///System.out.println(hands);
        //System.out.println(community);


        for (int i = 0; i < playersNum; i++) {
            List<Card> totalCard = new ArrayList<>(hands.get(i));
            totalCard.addAll(community);

            bestOfAllPlayers.add(bestValueOfSeven(totalCard));
        }

        //System.out.println(bestOfAllPlayers.get(0).setValue);
        //System.out.println(Arrays.toString(bestOfAllPlayers.get(0).pointValue));
        //System.out.println(bestOfAllPlayers.get(1).setValue);
        //System.out.println(Arrays.toString(bestOfAllPlayers.get(1).pointValue));



        for (int i = 0; i < playersNum; i++) {
            boolean isWinner = true; // Tie not included for win rate
            for (int j = 0; j < playersNum; j++) {
                HandValue player = bestOfAllPlayers.get(i);
                HandValue opponent = bestOfAllPlayers.get(j);
                if (player.CompareTo(opponent) == -1) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                return i;
            }
        }

        return -1;
    }



    public double preFlopWinRate(int playersNum, List<List<Card>> players) {
        curWinTimes = new int[playersNum];
        Set<Integer> exist = new TreeSet<>();

        for (int i = 0; i < playersNum; i++) {
            exist.add(players.get(i).get(0).getOrdinal());
            exist.add(players.get(i).get(1).getOrdinal());
        }


        int[] combination = new int[5];
        // initialize with lowest lexicographic combination
        for (int i = 0; i < 5; i++) {
            combination[i] = i;
        }
        while (combination[4] < 52) {
            // Do things on combination
            boolean valid = true;
            for (int i = 0; i < 5; i++) {
                if (exist.contains(combination[i])) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                List<Card> community = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    community.add(new Card(combination[i]));
                }
                int winner = getWinner(playersNum, players,community);
                curWinTimes[winner] += 1;
            }

            // generate next combination in lexicographic order
            int t = 4;
            while (t != 0 && combination[t] == 47 + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < 5; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        double games = 0;
        for (int i = 0; i < curWinTimes.length; i++) {
            games += curWinTimes[i];
        }
        double firstPlayerWinRate = curWinTimes[0] / games;

        return firstPlayerWinRate;
    }
}
