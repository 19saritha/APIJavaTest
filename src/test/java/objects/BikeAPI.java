package objects;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import static io.restassured.RestAssured.given;


public class BikeAPI {
    private RequestSpecification httpRequest;
    private Response response;
    private static int flag;

    public RequestSpecification createAPIRequest(String baseURL, String basePath) {
        RestAssured.baseURI = baseURL;
        RestAssured.basePath = basePath;
        httpRequest = given();
        return httpRequest;
    }

    public Response getAPIResponse(RequestSpecification request) {
        response = httpRequest.request(Method.GET);
        return response;
    }

    public boolean checkCityInCountry(String city, String country) {

        flag = getFlag(city, flag);
        boolean pf = false;
        try {


            if (httpRequest.get().jsonPath().getJsonObject("networks[" + flag + "].location.country").toString().equals(country)) {
                pf = true;

            } else {
                pf = false;
            }
        } catch (Exception e) {
        }
        return pf;
    


    }






    private int getFlag(String city, int flag) {
        List<String> networksList = httpRequest.get().jsonPath().getJsonObject("networks.location.city");
        for(String networkCity: networksList){
            if(networkCity.toString().equals(city)){
                break;
            }
            flag++;
        }
        return flag;
    }

    public String getLongitude() {
        return httpRequest.get().jsonPath().getJsonObject("networks["+flag+"].location.longitude").toString();
    }

    public String getLatitude() {
        return httpRequest.get().jsonPath().getJsonObject("networks["+flag+"].location.latitude").toString();
    }
}
