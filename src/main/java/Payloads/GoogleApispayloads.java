package Payloads;

public class GoogleApispayloads {

    public static String getdeletePayload(String place_id)
    {
        return "{\n" +
                "    \"place_id\":\""+place_id+"\"\n" +
                "}";
    }
}
