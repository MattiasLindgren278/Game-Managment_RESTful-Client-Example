package client;

import model.Game;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class GameClient {

    final static Client CLIENT = ClientBuilder.newClient();
    static WebTarget target = CLIENT.target("http://localhost:8080/GameREST/rest/games");

    public static void createGame(Game g) {
        target.request().post(Entity.json(g));
    }

    public static void updateGame(Game g) {
        target.request().put(Entity.json(g));
    }

    public static void deleteGame(String id) {
        target.path(id).request().delete();
    }

    public static Game findGameById(String id) {
        return target.path(id).request().get(Game.class);
    }

    public static List<Game> getAllGames() {
        return target.request().get(new GenericType<List<Game>>() {
        });
    }
}
