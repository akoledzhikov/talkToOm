package chat.websocket;


import org.eclipse.jetty.websocket.api.*;
import org.json.*;

import java.io.IOException;
import java.text.*;
import java.util.*;

import static j2html.TagCreator.*;
import static spark.Spark.*;


public class Chat
{
    public static void main(String[] args)
    {
        System.out.println("Starting up!");
        String portEnv = System.getenv("PORT");
        if (portEnv == null || portEnv.isEmpty())
        {
            port(4567);
        }
        else
        {
            port(Integer.valueOf(portEnv));
        }

        staticFiles.location("/public"); // index.html is served at localhost:4567 (default port)
        staticFiles.expireTime(600);
        webSocket("/chat", ChatWebSocketHandler.class);
        init();
    }


    // Sends a message from one user to all users, along with a list of current usernames
    public static void sendMessage(Session target, String message, String messageOwner)
    {
        try
        {
            target.getRemote()
                  .sendString(String.valueOf(new JSONObject().put("userMessage",
                                                                  createHtmlMessageFromSender(messageOwner,
                                                                                              message))));
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // Builds a HTML element with a sender-name, a message, and a timestamp,
    private static String createHtmlMessageFromSender(String sender, String message)
    {
        return article().with(b(sender + " says:"),
                              p(message),
                              span().withClass("timestamp")
                                    .withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))).render();
    }

}
