import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"id", "revision","team"})
public class Player {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("_rev")
    private String revision;


    private String name;
    private String position;
    private int age;
    private float price;
    private int goals;
    private int assists;
    private int cleanSheets;

    public Player(String id, String revision, String name, String position, int age, float price, int goals, int assists, int cleanSheets) {
        this.id = id;
        this.revision = revision;
        this.name = name;
        this.position = position;
        this.age = age;
        this.price = price;
        this.goals = goals;
        this.assists = assists;
        this.cleanSheets = cleanSheets;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }


    public Player(String name, String position, int age, float price, int goals, int assists,int cleanSheets) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.price = price;
        this.goals = goals;
        this.assists = assists;
        this.cleanSheets = cleanSheets;
    }

    public Player() {
        this.name = "name";
        this.position = "position";
        this.age = 0;
        this.price = 0;
        this.goals = 0;
        this.assists = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", goals=" + goals +
                ", assists=" + assists +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }



}
