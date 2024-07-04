import java.util.ArrayList;

public class Book extends Material {

    Person writer;
    int numberOfPages;

    public Book(int id, String name, ArrayList<Integer> scores, int release_year, int price, Category category, String type, Person writer, int numberOfPages){
        super(id, name, scores, release_year, price, category, type);
        this.writer = writer;
        this.numberOfPages = numberOfPages;
    }

    public void setWriter(Person newWriter){
        this.writer = newWriter;
    }

    @Override
    public void showDetail(){
        System.out.println("ID : " + id + "Book: " + name + " by " + writer.firstName + " " + writer.lastName + ", Price: " + price + ", Release Year: " + release_year + ", Pages: " + numberOfPages + ", Category: " + category.categoryName);
    }
}