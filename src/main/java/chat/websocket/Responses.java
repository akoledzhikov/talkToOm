package chat.websocket;


import java.util.Random;


public class Responses
{
    private static String[] welcomeMessages = new String[]{"Welcome, my child!",
                                                           "Pray, and your prayer will be answered!",
                                                           "You have my godly attention.",
                                                           "I will not hear your prayers, lest you offer some lettuce first."};

    private static String[] sillyResponses = new String[]{
                                                          "No prayers will be answered until I get some lettuce!",
                                                          "Very well, my godly persona finds your request ... pleasing, and will fulfil it!",
                                                          "I don't quite understand what you need, but everything will be alright in the end.",
                                                          "Hmpf... who were you, again?", 
                                                          "Your prayer has been heard, my child, and will be executed in due time. Prayers that have to be answered before it: 42442"};


    public static String getWelcomeMessage()
    {
        return welcomeMessages[new Random().nextInt(welcomeMessages.length)];
    }


    public static String getPrayerAnswer(String message)
    {
        return sillyResponses[new Random().nextInt(sillyResponses.length)];
    }
}
