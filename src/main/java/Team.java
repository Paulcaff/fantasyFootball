import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Team {
    @JsonProperty("_id")
    private String id;

    @JsonProperty("_rev")
    private String revision;

    private String team;

    private List<Player> players = new ArrayList<Player>() ;

    public Team(String id, String revision, String team) {
        this.id = id;
        this.revision = revision;
        this.team = team;

    }


    public Team() {
        this.id = "id";
        this.revision = "revision";
        this.team = "team";

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers(){
        return  players ;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", revision='" + revision + '\'' +
                ", team='" + team + '\'' +
                ", players=" + players +
                '}';
    }
}
