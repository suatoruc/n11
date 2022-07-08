package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Category;
import pojo.PetID;
import pojo.Tags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetshoreApi extends BaseApi {
    int petID;

    Response response;

    @Given("Kullanici {string} endpoint ine response yollar")
    public void kullaniciEndpointIneResponseYollar(String pathParam) {
        setUp();
        spec.pathParams("1", pathParam, "2", 1);
        response = given().spec(spec).accept(" application/json").when().get("/{1}/{2}");
        response.prettyPeek();

    }

    @And("Kullanici status code nun {int} oldugunu dogrular")
    public void kullaniciStatusCodeNunOldugunuDogrular(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }

    @Then("kullanici {int} nolu ped in adinin {string} oldgunu dogrular")
    public void kullaniciNoluPedInAdininOldgunuDogrular(int number, String petName) {

        PetID actulData = response.as(PetID.class);
        System.out.println(actulData.getName());
        Assert.assertEquals(petName, actulData.getName());
    }

    @Given("Kullanici post islemi icin endpointe gonderecegi requesti gonderir")
    public void kullaniciPostIslemiIcinEndpointeGonderecegiRequestiGonderir() {
        setUp();
        spec.pathParams("1", "pet", "2", 1);
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 1);
        requestBody.put("name", "poncik");
        requestBody.put("status", "available");

        response = given().spec(spec).accept("application/json").headers("application/json", "https://petstore.swagger.io/ -d YOUR_JSON_BODY").
                body(requestBody).post("/{1}/{2}");
    }

    @Then("Kullanici {string} islemi ile gelen responce ekrana yazdirir")
    public void kullaniciIslemiIleGelenResponceEkranaYazdirir(String islem) {
        response.jsonPath().prettyPeek();
    }

    @And("Kullanici post islemi sonucu status code {int} oldugunu test eder")
    public void kullaniciPostIslemiSonucuStatusCodeOldugunuTestEder(int statusCode) {
        Assert.assertFalse("desteklenmeyen medya tipi 415 status code hatası verir", response.getStatusCode() == statusCode);
    }

    @Given("Kullanici post islemi icin requestbody sini hazirlar ve endpointe gonderir")
    public void kullaniciPostIslemiIcinRequestbodySiniHazirlarVeEndpointeGonderir() {
        setUp();
        spec.pathParam("1", "pet");
        Category category = new Category(1, "poncikk");
        Tags tags = new Tags(0, "yavru");
        ArrayList<Tags> tags1 = new ArrayList<>();
        ArrayList<String> photo = new ArrayList<>();
        photo.add("asaa");
        PetID requestBody = new PetID(1, category, "poncikk", photo, tags1, "available");

        response = given().spec(spec).
                accept("application/json").
                contentType("application/json").
                body(requestBody).
                post("/{1}");
    }

    @And("Kullanici post isleminden sonra status code {int} oldugunu teyit eder")
    public void kullaniciPostIslemindenSonraStatusCodeOldugunuTeyitEder(int statusCode) {

        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Given("Kullanici put islemi icin requestini hazırlar ve entpointe gonderir")
    public void kullaniciPutIslemiIcinRequestiniHazırlarVeEntpointeGonderir() {
        setUp();
        spec.pathParam("1", "pet");
        Category category = new Category(1, "poncikk");
        Tags tags = new Tags(0, "yavru");
        ArrayList<Tags> tags1 = new ArrayList<>();
        ArrayList<String> photo = new ArrayList<>();
        photo.add("asaa");
        PetID requestBody = new PetID(1, category, "bacaksiz", photo, tags1, "available");

        response = given().spec(spec).
                accept("application/json").
                contentType("application/json").
                body(requestBody).
                put("/{1}");
    }


    @And("Kullanici put islemi sonrasi pet in adinin {string} olarak guncellendigini dogrular")
    public void kullaniciPutIslemiSonrasiPetInAdininOlarakGuncellendiginiDogrular(String guncellenenIsim) {
        PetID actulData = response.as(PetID.class);
        Assert.assertEquals(guncellenenIsim, actulData.getName());
    }

    @Given("Kullanici delete islemi icin requestini hazırlar ve endpointe gonderir")
    public void kullaniciDeleteIslemiIcinRequestiniHazırlarVeEndpointeGonderir() {
        setUp();
        petID = 1;
        spec.pathParams("1", "pet", "2", petID);
        response = given().spec(spec).auth().basic("api_key", "12345").
                accept("application/json").when().delete("/{1}/{2}");
    }

    @And("Kullanici {string} isleminin basarili oldugunu statuscodun {int} gelmesi ile dogrular")
    public void kullaniciIslemininBasariliOldugunuStatuscodunGelmesiIleDogrular(String arg0, int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("Kullanici delete islemini dogrulamak icin silinen id ye get yapar ve donen response codun {int} oldugunu dogrular")
    public void kullaniciDeleteIsleminiDogrulamakIcinSilinenIdYeGetYaparVeDonenResponseCodunOldugunuDogrular(int statuscode) {
        setUp();
        spec.pathParams("1", "pet", "2", petID);
        response = given().spec(spec).accept(" application/json").when().get("/{1}/{2}");
        Assert.assertEquals(statuscode, response.getStatusCode());

    }


}
