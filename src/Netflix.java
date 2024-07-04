import java.util.ArrayList;
import java.util.Comparator;

public class Netflix {

    private ArrayList<Material> materials = new ArrayList<>();
    private  User credential;
    private boolean isLogin;

    public Netflix(ArrayList<Material> materials){
        this.materials = new ArrayList<>();
        this.isLogin = false;
    }

    public void setCredential(User user) {
        this.credential = user;
    }

    public void login(User user) {
        if (credential != null && user.userName.equals(credential.userName) && user.password.equals(credential.password)) {
            isLogin = true;
            credential = user;
        } else {
            System.out.println("Please check your information again.");
        }
    }

    public void addMovie(Movie m1){
        if (isLogin){
            materials.add(m1);
        } else {
            System.out.println("Please login first !");
        }
    }

    public void addBook(Book b1){
        if (isLogin){
            materials.add(b1);
        } else {
            System.out.println("Please login first !");
        }
    }

    public void addMaterial(Material m2){
        if (isLogin){
            materials.add(m2);
        } else {
            System.out.println("Please login first !");
        }
    }

    public void showBestMaterial() {

        Material best = materials.stream()
                .max(Comparator.comparingDouble(Material::getAvgScore))
                .orElseThrow(() -> new RuntimeException("No materials available"));

        best.showDetail();
    }

    public void showLowestScoreMovie() {
        materials.stream()
                .filter(material -> material instanceof Movie)
                .map(material -> (Movie) material)
                .min(Comparator.comparingDouble(Movie::getAvgScore))
                .ifPresentOrElse(
                        Movie::showDetail,
                        () -> System.out.println("No movies available.")
                );
    }

    public void showMostExpensiveMaterialByCategory(int categoryId) {

        materials.stream()
                .filter(material -> material.category.id == categoryId)
                .max(Comparator.comparingDouble(Material -> Material.price))
                .ifPresentOrElse(
                        Material::showDetail,
                        () -> System.out.println("No materials found for the given category.")
                );
    }

    public void showMoviesByActor(int actorId) {
        boolean anyMoviesFound = materials.stream()
                .filter(material -> material instanceof Movie)
                .map(material -> (Movie) material)
                .filter(movie -> movie.actors.stream().anyMatch(actor -> actor.id == actorId))
                .peek(Movie::showDetail)
                .count() > 0;

        if (!anyMoviesFound) {
            System.out.println("No movies found for the given actor.");
        }
    }


}