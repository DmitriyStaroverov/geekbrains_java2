package lesson1.marathon;

public abstract class Obstacle {
    public abstract void doIt(Competitor competitor);
}

class Wall extends Obstacle{

    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump ( height );


    }
}

class Cross extends Obstacle{

    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run ( length );
    }
}



class Course{
    private Obstacle[] obstacles;

    public Course(Obstacle...obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team){
        for (Competitor competitor: team.getMembers ())
            for (Obstacle obst : obstacles) {
                obst.doIt ( competitor );
                if (!(competitor.isActive ())) break;
            }
    }
}

class MainClass{
    public static void main(String[] args) {
        Course course = new Course ( new Cross ( 4000 ), new Wall ( 50 ) );
        Team team = new Team ("Name", new Human ( "Боб" ), new Cat ( "Барсик" ), new Dog ( "Бобик" ));
        course.doIt ( team );
        team.showResult ();
    }
}