package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static config.ApiEndpoint.*;
import static io.restassured.RestAssured.given;

public class UserClient {
    @Step("Создание пользователя")
    public Response createUser(User user){
        return given().
                spec(getBaseSpec())
                .body(user)
                .post(REGISTER);
    }

    @Step("Авторизация пользователя")
    public Response loginUser(User user){
        return given()
                .spec(getBaseSpec())
                .body(user)
                .post(LOGIN);
    }

    @Step("Получение accessToken пользовател")
    public String getUserToken(Response response) {
        String token = response.jsonPath().getString("accessToken");
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return token;
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        given()
                .spec(getBaseSpec())
                .header("Authorization", "Bearer " + accessToken)
                .delete(USER);
    }
}
