package at.maintenanceMonitor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Path("/api/maintenanceMode")
public class MonitorController {
    public static final String INITIAL_MESSAGE = "-";
    public static String message = INITIAL_MESSAGE;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/frontend")
    public static String loadWebsite() {
        try {
            File file = new File("HTML/index.html");
            String content = Files.readString(Paths.get("HTML/index.html"));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "index.html kann ich gefunden werden";
        }
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("")
    public static Response getMessage() {
        System.out.println("Message requested. Current message is: " + message);

        Response.ResponseBuilder rb = Response.ok(message);
        return rb.header("Access-Control-Allow-Origin", "*").build();
    }

    @PUT
    @Path("/reset")
    public static Response resetMessage() {
        message = INITIAL_MESSAGE;
        return Response.noContent().build();
    }

    @POST
    @Path("/setMessage/{newMessage}")
    @Consumes(MediaType.TEXT_PLAIN)
    public static Response postMessage(@PathParam("newMessage") String newMessage) {
        if (newMessage != null && !newMessage.isBlank()) {
            System.out.printf("new Message:%s", newMessage);
            message = newMessage;
        }
        return Response.noContent().build();
    }


}
