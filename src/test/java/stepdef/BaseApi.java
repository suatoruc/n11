package stepdef;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    protected RequestSpecification spec;


    public void setUp(){
        spec= new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2").build();
    }
}
