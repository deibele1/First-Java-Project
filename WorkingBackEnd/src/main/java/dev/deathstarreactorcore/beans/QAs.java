package dev.deathstarreactorcore.beans;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public class QAs {
    public QAs(){super();}
    @Enumerated
    private Question question1;
    @Enumerated
    private Question question2;
    @Enumerated
    private Question question3;
    private String answer1;
    private String answer2;
    private String answer3;
    QAs(String ans1, String ans2, String ans3, int q1, int q2, int q3) {
        this.question1 = Question.setByInt(q1);
        this.question2 = Question.setByInt(q2);
        this.question3 = Question.setByInt(q3);
        this.answer1 = ans1;
        this.answer2 = ans2;
        this.answer3 = ans3;
    }
    /**
     * @return the answer1
     */
    public String getAnswer1() {
        return answer1;
    }

    /**
     * @return the answer2
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * @return the answer3
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * @return the question1
     */
    public Question getQuestion1() {
        return question1;
    }

    /**
     * @return the question2
     */
    public Question getQuestion2() {
        return question2;
    }

    /**
     * @return the question3
     */
    public Question getQuestion3() {
        return question3;
    }

}
