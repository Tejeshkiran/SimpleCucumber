package GoogleApisSerializationPayload;

import java.util.ArrayList;

public class DataSetter {

    public static Address getAddPlaceApiPayload(String s1, String s2, String s3)
    {
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);

        Address address = new Address();
        address.setLocation(location);
        address.setAccuracy(50);
        address.setName(s1);
        address.setPhone_number("(+91) 983 893 3937");
        address.setAddress(s2);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(0,"shoe park");
        arrayList.add(1,"shop");

        address.setTypes(arrayList);
        address.setWebsite("http://google.com");
        address.setLanguage(s3);

        return address;

    }
}
