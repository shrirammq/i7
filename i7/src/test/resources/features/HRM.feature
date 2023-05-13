Feature: HRM Application Automation using Cucumber

  @Regression @Smoke
  Scenario: AddEmployee
    When addEmployee

  @Regression
  Scenario: EditEmployee
    When editEmployee

  @Smoke
  Scenario: DeleteEmployee
    When deleteEmployee
