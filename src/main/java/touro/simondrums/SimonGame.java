package touro.simondrums;

import java.util.*;

public class SimonGame {
    private int highScore = 0;

    private ArrayList<Drum> drumSequence = new ArrayList<>();
    private int index = 0;
    private boolean finishedRound = false;
    Random rand = new Random();
    List<Drum> drums = Arrays.asList(Drum.values());
    int amountDrums = drums.size();

    public SimonGame() {
        newGame();
    }

    public void newGame() {
        index = 0;
        finishedRound = false;
        drumSequence.clear();
        buildSequence();
    }

    public boolean checkResponse(Drum userResponse) {
        int size = drumSequence.size();
        finishedRound = false;

        if (!userResponse.equals(drumSequence.get(index))) {
            return false;
        }
        else {
            if (index < size - 1) {
                index += 1;
            } else {
                finishedRound = true;
                buildSequence();
                index = 0;

                highScore = Math.max(highScore, size);
            }
            return true;
        }
    }

    public int getHighScore() {
        return highScore;
    }

    public void buildSequence() {
        Drum nextDrum = drums.get(rand.nextInt(amountDrums));
        drumSequence.add(nextDrum);
    }

    public ArrayList<Drum> getDrumSequence() {
        return drumSequence;
    }

    public boolean isFinishedRound() {
        return finishedRound;
    }
}
