import java.util.ArrayList;

public class Movie extends Material {

    ArrayList<Person> actors;
    Person director;

    public Movie(int id, String name, ArrayList<Integer> scores, int release_year, int price, Category category, String type, ArrayList<Person> actors, Person director){
        super(id, name, scores, release_year, price, category, type);
        this.actors = actors;
        this.director = director;
    }

    public void addActor(Person actor){
        actors.add(actor); // adds a new actor to the actors arraylist.
    }

    @Override
    public void showDetail() {
        System.out.println("ID : " + id + " Movie: " + name + ", Director: " + director.firstName + " " + director.lastName + ", Price: " + price + ", Release Year: " + release_year + ", Category: " + category.categoryName);

        System.out.println("Actors: ");
        for(Person actor : actors){
            System.out.println("- " + actor.firstName + " " + actor.lastName);
        }
    }
}