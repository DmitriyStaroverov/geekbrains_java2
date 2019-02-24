package lesson1.marathon;

public class Team {

    private String title;
    private Competitor[] members;

    public Competitor[] getMembers() {
        return members;
    }

    public Team(String title, Competitor...members) {
        this.title = title;
        this.members = members;
    }

    void showResult(){
        for (Competitor competitor :
                members) {
            competitor.info ();

        }
    }



}
