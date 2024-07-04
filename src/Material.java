import java.util.ArrayList;

public abstract class Material {

    int id;
    String name;
    ArrayList<Integer> scores;
    int release_year;
    Category category;
    int price;
    String type; // book or movie

    public Material(int id, String name, ArrayList<Integer> scores, int release_year, int price, Category category, String type){
        this.id = id;
        this.name = name;
        this.scores = scores;
        this.release_year = release_year;
        this.price = price;
        this.category = category;
        this.type = type;
    }

    public void addScore(int score){
        this.scores.add(score);
    }

    public double getAvgScore(){

        if(scores.isEmpty()){
            return 0;
        }

        int sum = 0;
        for (int point: scores){
            sum += point;
        }

        return sum / (double) scores.size();
    }

    public abstract void showDetail();
}