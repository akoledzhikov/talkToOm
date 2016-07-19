package chat.websocket;


import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;


@WebSocket
public class ChatWebSocketHandler
{

    private String sender, msg;


    @OnWebSocketConnect
    public void onConnect(Session user)
        throws Exception
    {
        user.setIdleTimeout(60 * 60 * 1000);
        sender = "Quantz Om-Morgoth 'The Almighty'";
        msg = Responses.getWelcomeMessage();
        Chat.sendMessage(user, msg, sender);
    }


    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason)
    {

    }


    @OnWebSocketMessage
    public void onMessage(Session user, String message)
    {
        sender = "Quantz Om-Morgoth 'The Almighty'";
        msg = Responses.getPrayerAnswer(message);
        Chat.sendMessage(user, message, "Me");
        Chat.sendMessage(user, msg, sender);
    }

}
