package parent.enumerated;

import static parent.enumerated.Outcome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(LOSE, WIN, DRAW),
    ROCK(LOSE, WIN, DRAW);
    private Outcome vPAPER, vSCISSORS, vRock;

    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vRock = rock;
    }

    @Override
    public Outcome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vRock;
        }
    }

    public static void main(String[] args) {
        
    }
}
