package com.testing.gherkinsDefinitions;

import com.testing.serenitySteps.JuiceShopSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;

import java.io.IOException;

public class JuiceShopDefinitions {


  @When("^the user logs in using the following data:$")
  public void theUserLogsInUsingTheFollowingData(DataTable dataTable) throws IOException {
    JuiceShopSteps.logInAnAccount(dataTable);
  }

  @When("^the user changes password using the following data:$")
  public void theUserChangesPasswordUsingTheFollowingData(DataTable dataTable) throws IOException {
    JuiceShopSteps.changePassword(dataTable);
  }
}
