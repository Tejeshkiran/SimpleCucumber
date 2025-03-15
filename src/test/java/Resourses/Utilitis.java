package Resourses;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class Utilitis {
    static PrintStream stream;
    static RequestSpecification reqSpec;

    public static RequestSpecification getRequestSpecification() throws IOException {
        if(reqSpec==null) {
            stream = new PrintStream( new FileOutputStream("logging.txt"));
            reqSpec = new RequestSpecBuilder().setBaseUri(getBaseUri())
                    .addFilter(RequestLoggingFilter.logRequestTo(stream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                    .addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON).build();
            return reqSpec;
        }
        return reqSpec;
    }
    public static ResponseSpecification getResponseSpecification(int statusCode)
    {
        ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(statusCode)
                .expectContentType(ContentType.JSON).build();
        return resSpec;
    }
    public static String getBaseUri() throws IOException {
        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+ "/src/test/java/Resourses/global.properties"));
        Properties prop = new Properties();
        prop.load(fis);
        String baseUri = prop.getProperty("baseuri");
        return baseUri;
    }
    public static String JsonParse(Response resp, String key)
    {
        JsonPath js = new JsonPath(resp.asString());
        return js.getString(key);
    }
}
