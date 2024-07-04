import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Person actor1 = new Person(1, 25,"Ahmet", "Ahmet");
        Person actor2 = new Person(2, 30,"Ali", "Ali");
        Person actor3 = new Person(3, 25,"Can", "Can");
        Person actor4 = new Person(4, 30,"Efe", "Efe");

        Person writer1 = new Person(5, 35,"Veli", "Veli");
        Person writer2 = new Person(6, 39,"Salih", "Salih");

        Person director1 = new Person(7, 45,"Murat", "Murat");
        Person director2 = new Person(8, 38,"Mehmet", "Mehmet");

        Category scienceFiction  = new Category(1, "FIC", "Fiction");
        Category action = new Category(2, "ACT", "Action");
        Category biography = new Category(3, "BIO", "Biography");

        ArrayList<Person> inceptionActors = new ArrayList<>();
        inceptionActors.add(actor1);
        inceptionActors.add(actor2);

        ArrayList<Person> ArkaSokaklarActors = new ArrayList<>();
        ArkaSokaklarActors.add(actor3);
        ArkaSokaklarActors.add(actor4);

        ArrayList<Person> denemeActors = new ArrayList<>();
        denemeActors.add(actor1);
        denemeActors.add(actor2);

        Movie inception = new Movie(1, "Inception", new ArrayList<>(), 2010, 100, scienceFiction , "movie", inceptionActors, director1);
        Movie deneme = new Movie(2, "Deneme", new ArrayList<>(), 2010, 50, scienceFiction , "movie", denemeActors, director1);
        Movie ArkaSokaklar = new Movie(3, "ArkaSokaklar", new ArrayList<>(), 2000, 50, action , "movie", ArkaSokaklarActors, director2);

        inception.addScore(10);
        inception.addScore(55);

        ArkaSokaklar.addScore(0);
        ArkaSokaklar.addScore(0);

        deneme.addScore(5);
        deneme.addScore(10);

        Book Lorem = new Book(1,"Lorem", new ArrayList<>(), 1850, 60, biography, "book", writer1, 500);
        Book harryPotter = new Book(2, "Harry Potter", new ArrayList<>(), 1997, 20, scienceFiction, "book", writer2, 80);

        harryPotter.addScore(8);
        harryPotter.addScore(9);

        Lorem.addScore(35);
        Lorem.addScore(45);

        User user = new User(1, "Nihat", "Çetin", "user", "123456");

        ArrayList<Material> materials = new ArrayList<>();
        Netflix netflix = new Netflix(materials);

        netflix.setCredential(user);
        netflix.login(user);

        netflix.addMovie(inception);
        netflix.addMovie(ArkaSokaklar);
        netflix.addMovie(deneme); 
        netflix.addBook(Lorem);
        netflix.addBook(harryPotter);

        System.out.println("\n Best Material");
        netflix.showBestMaterial();

        System.out.println("\n Lowest Score Movie");
        netflix.showLowestScoreMovie();

        System.out.println("\n Most Expensive Material by Category");
        netflix.showMostExpensiveMaterialByCategory(1);

        System.out.println("\n Movies By Actor");
        netflix.showMoviesByActor(1);
    }
}