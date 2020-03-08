package client;

import model.Console;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import utilities.Credentials;
import utilities.InputAssistance;

public class ConsoleClient {

    static Client client = ClientBuilder.newClient();
    static WebTarget target = client.target("http://localhost:8080/GameREST/rest/consoles");

    public static void createConsole(Console c) {
        Response response = target.request().post(Entity.json(c));
        if (response.getStatus() == 401) {
            Credentials credentials = credtentialsMenu();
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(credentials.getUserName(), credentials.getPassword());
            client.register(feature);
            target.request().post(Entity.json(c));
        }

    }

    public static void updateConsole(Console c) {
        Response response = target.request().put(Entity.json(c));
        if (response.getStatus() == 401) {
            Credentials credentials = credtentialsMenu();
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(credentials.getUserName(), credentials.getPassword());
            client.register(feature);
            response = target.request().put(Entity.json(c));
        }
    }

    public static void deleteConsole(String id) {
        Response response = target.path(id).request().delete();
        if (response.getStatus() == 401) {
            Credentials credentials = credtentialsMenu();
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(credentials.getUserName(), credentials.getPassword());
            client.register(feature);
            response = target.path(id).request().delete();
        }
    }

    public static Console findConsoleByName(String id) {
        return target.path(id).request().get(Console.class);
    }

    public static List<Console> getAllConsoles() {
        return target.request().get(new GenericType<List<Console>>() {
        });
    }

    private static Credentials credtentialsMenu() {
        System.out.println("");
        System.out.println("You must login to complete requested operation.");
        System.out.print("Enter username: ");
        String userName = InputAssistance.stringInput();
        System.out.print("Enter password: ");
        String password = InputAssistance.stringInput();
        return new Credentials(userName, password);
    }

}
