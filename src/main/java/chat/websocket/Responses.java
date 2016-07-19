package chat.websocket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Responses
{
    private static List<String> welcomeMessages;

    private static List<String> genericResponses;

    static
    {
        welcomeMessages = new ArrayList<String>();
        genericResponses = new ArrayList<String>();
        try
        {
            readFileIntoList(welcomeMessages, "private/welcomeMessages.txt");
            readFileIntoList(genericResponses, "private/genericResponses.txt");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static String getWelcomeMessage()
    {
        return welcomeMessages.get(new Random().nextInt(welcomeMessages.size()));
    }


    public static String getPrayerAnswer(String message)
    {
        return genericResponses.get(new Random().nextInt(genericResponses.size()));
    }


    private static void readFileIntoList(List<String> list, String file)
        throws IOException
    {
        try (InputStream is = Responses.class.getClassLoader().getResourceAsStream(file))
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null)
            {
                line = line.trim();
                list.add(line);
            }
        }
    }
}
