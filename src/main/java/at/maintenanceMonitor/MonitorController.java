package at.maintenanceMonitor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/maintenanceMode")
public class MonitorController {
    public static final String INITIAL_MESSAGE = "-";
    public static String message = INITIAL_MESSAGE;



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
