import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.changes.ChangesCommand;
import org.ektorp.changes.DocumentChange;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.DesignDocument;
import javax.swing.*;


public class JavaCouchDB {
    public static void main(String[] args) throws MalformedURLException {
       JavaCouchDB javaCouchDB = new JavaCouchDB();
       updateDocument("4e64de39eb0fe560d23590e0d902c7c9","Paul","Defender",27,6,12,4,3);

   }

    public void createDocument(String team,String name, String position, int age, float price, int goals, int assists, int cleanSheets ) throws MalformedURLException {
        // ------------- Creating Connection--------------------------//
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        db.createDatabaseIfNotExists();
        HashMap<String, Object> map = new HashMap<String, Object>();
        Player player = new Player(name,position,age,price,goals,assists,cleanSheets);

        map.put("team: "+team,player);

        db.create(map);
    }

    public static void updateDocument(String team_id,String name, String position, int age, float price, int goals, int assists, int cleanSheets )throws MalformedURLException{
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);

        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        db.createDatabaseIfNotExists();

        Player player = new Player(name,position,age,price,goals,assists,cleanSheets);

        Map<String, Object> map = db.find(Map.class,team_id);
        map.put(team_id,player);

        db.update(map);
        }



    public void deleteDocument(String id) throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);

        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        db.createDatabaseIfNotExists();

        Map resultMap = db.find(Map.class, id);

        if (resultMap != null) {
            db.delete(resultMap);
        }
    }

    public static void getDocumentById(String team_id)throws MalformedURLException{
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);

        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        db.createDatabaseIfNotExists();

        Map<String, Object> map = db.find(Map.class,team_id);

        System.out.println("------------ Displaying Team ---------------");
        for (Object id : map.keySet()) {
            if (!id.equals("_design/Team")) {
                System.out.println(id + ": " + map.get(id));
            }
        }
        System.out.println("--------------------------------------------");
    }

    public static void getAllDocuments()throws MalformedURLException{
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        ChangesCommand.Builder builder = new ChangesCommand.Builder();
        ChangesCommand changesCommand =builder.build() ;

        List<DocumentChange> documentChangeList=db.changes(changesCommand);


        for(int i=0;i<documentChangeList.size()-1;i++) {
            if (!documentChangeList.get(i).isDeleted())  {
               // System.out.println(documentChangeList.get(i).getId() + " - " + documentChangeList.get(i).isDeleted());
                Map<String, Object> map3 = db.find(Map.class,documentChangeList.get(i).getId());
                getDocumentById(documentChangeList.get(i).getId());
            }
        }

    }

    public int getSquadSize(String teamName) throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);

        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        db.createDatabaseIfNotExists();

        ViewQuery query = new ViewQuery().designDocId("_design/Team").dbPath(db.path()).viewName("squadSize");
        query.key(teamName);
        ViewResult r = db.queryView(query);

        if(r.getSize() == 0) {
            System.out.print( teamName+" No Players Found");
            return 0;
        }
        else{
            System.out.print( teamName + "'s Squad Size = "+r.getRows().get(0).getValueAsInt());
            return r.getRows().get(0).getValueAsInt();
        }

    }

    public String getPlayerByPosition(String position) throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);

        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        db.createDatabaseIfNotExists();

        ViewQuery query = new ViewQuery().designDocId("_design/Team").dbPath(db.path()).viewName("byPosition");
        query.key(position);
        ViewResult r = db.queryView(query);
        String list = "";

        if (r.getSize() == 0) {
            list = list +"No Players found";
        } else {
            for (int i = 0; i < r.getSize(); i++) {

                list = list+(r.getRows().get(i).toString())+ "\n";
            }
        }
        return list;
    }


    public String getPlayerByTeam(String team) throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);

        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        db.createDatabaseIfNotExists();

        ViewQuery query = new ViewQuery().designDocId("_design/Team").dbPath(db.path()).viewName("byTeam");
        query.key(team);
        ViewResult r = db.queryView(query);
        String players = "";

        if(r.getSize() == 0) {
            players += "No "+team+" Players Found";
        }
        else{
            for (int i = 0; i < r.getSize() ; i++) {
                players += r.getRows().get(i).toString() + "\n";
            }
        }
        return players;
    }

    public String getPlayer(String name) throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("paul3112")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);

        CouchDbConnector db = new StdCouchDbConnector("fantasyfootball", dbInstance);
        db.createDatabaseIfNotExists();

        ViewQuery query = new ViewQuery().designDocId("_design/Team").dbPath(db.path()).viewName("byPlayer");
        query.key(name);
        ViewResult r = db.queryView(query);
        String player = "";

        if(r.getSize() == 0) {
            player += "No Players found";
        }
        else{
            for (int i = 0; i < r.getSize() ; i++) {
                player += (r.getRows().get(i).toString()) + "\n";
            }
        }
        return player;
    }



}