package org.pattersonclippers.drakequizappnn;

public class Highscore {

    private int score;
    private String name;

    public Highscore(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public Highscore() { score = 0; name = "unknown";
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Highscore{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}


