package advent2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day22Test {

    private String sample = "Player 1:\n" +
            "9\n" +
            "2\n" +
            "6\n" +
            "3\n" +
            "1\n" +
            "\n" +
            "Player 2:\n" +
            "5\n" +
            "8\n" +
            "4\n" +
            "7\n" +
            "10";

    private List<Integer> deck1 = new ArrayList<>();
    private List<Integer> deck2 = new ArrayList<>();
    private Integer roundWinner = 0;

    private void setupDecks(String input) {
        boolean deck1IsActive = true;
        for (String s : input.split("\n")) {
            if (s.isEmpty() || s.contains("Player 1")) {
                continue;
            }
            if (s.contains("Player 2")) {
                deck1IsActive = false;
                continue;
            }
            if (deck1IsActive) {
                deck1.add(Integer.parseInt(s));
            } else {
                deck2.add(Integer.parseInt(s));
            }
        }
    }

    private void playRound() {
        Integer card1 = deck1.get(0);
        Integer card2 = deck2.get(0);
        if (card1 > card2) {
            deck2.remove(0);
            deck1.remove(0);
            deck1.add(card1);
            deck1.add(card2);
        } else {
            deck2.remove(0);
            deck1.remove(0);
            deck2.add(card2);
            deck2.add(card1);
        }
    }

    private void play(String input) {
        int countRounds = 1;
        setupDecks(input);
        boolean keepPlaying = true;
        while(keepPlaying) {
            playRound();
            if (deck1.size() == 0 || deck2.size() == 0) {
                keepPlaying = false;
            }
            if (keepPlaying) {
                countRounds++;
            }
        }
        System.out.println(countRounds);
        if (deck1.size() == 0) {
            countScore(deck2);
            roundWinner = 2;
        } else {
            countScore(deck1);
            roundWinner = 1;
        }
    }

    private void countScore(List<Integer> deck) {
        int score = 0;
        for (int i = 0; i < deck.size(); i++) {
            int point = deck.get(i);
            score += point * (deck.size() - i);
        }
        System.out.println(score);
    }

    @Test
    public void test() {
        play(input);
    }

    private String input = "Player 1:\n" +
            "19\n" +
            "5\n" +
            "35\n" +
            "6\n" +
            "12\n" +
            "22\n" +
            "45\n" +
            "39\n" +
            "14\n" +
            "42\n" +
            "47\n" +
            "38\n" +
            "2\n" +
            "26\n" +
            "13\n" +
            "30\n" +
            "4\n" +
            "34\n" +
            "43\n" +
            "40\n" +
            "16\n" +
            "8\n" +
            "23\n" +
            "50\n" +
            "36\n" +
            "\n" +
            "Player 2:\n" +
            "1\n" +
            "21\n" +
            "29\n" +
            "41\n" +
            "32\n" +
            "28\n" +
            "9\n" +
            "37\n" +
            "49\n" +
            "20\n" +
            "17\n" +
            "27\n" +
            "24\n" +
            "3\n" +
            "33\n" +
            "44\n" +
            "48\n" +
            "31\n" +
            "15\n" +
            "25\n" +
            "18\n" +
            "46\n" +
            "7\n" +
            "10\n" +
            "11";
}
