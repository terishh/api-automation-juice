package com.testing.serenitySteps;

import com.testing.requestBodies.BaseRequestBody;
import cucumber.api.DataTable;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.util.*;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

@SuppressWarnings("unchecked")
public class JuiceShopSteps extends BaseSteps {
  private final static String _REST_USER_LOGIN_ = "/rest/user/login/";

  @Step
  public static void logInAnAccount(DataTable dataTable) throws IOException {
    sendRequestWithBodyJson(POST, _REST_USER_LOGIN_, createBody(handleRandomEmail(dataTable)));
    if (((Response) sessionVariableCalled(RESPONSE)).statusCode() == 200){
      saveValueInPathToSessionVariable("authentication --> token", "token");
      saveValueInPathToSessionVariable("authentication --> bid", "basket_id");
    }
  }

  @Step
  public static void changePassword(DataTable dataTable) throws IOException {
    Map<String, String> requestData = dataTable.asMap(String.class, String.class);
    sendRequestWithBodyJson(GET, createChangePasswordEndpoint(
            requestData.get("current"),
            requestData.get("new"),
            requestData.get("repeat")), "{}");
  }

  // Private

  private static String createChangePasswordEndpoint(String current, String new_, String repeat){
    return "/rest/user/change-password?current=" + current + "&new=" + new_ + "&repeat=" + repeat;
  }

  private static Map<String, Object> handleRandomEmail(DataTable dataTable){
    Map<String, Object> map = new HashMap<>(dataTable.asMap(String.class, String.class));
    if(map.get("email").toString().equals(RANDOM_EMAIL)){
      map.replace("email", sessionVariableCalled(RANDOM_EMAIL));
    }
    return map;
  }
}
