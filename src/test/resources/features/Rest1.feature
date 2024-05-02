@bookerAPI @createBooking
Feature: To create a new booking in restful-booker

  @createBookingDataTable
  Scenario: To create new booking using cucumber Data Table
    Given user has access to endpoint 
    When user creates a booking
    Then user should get the response code
    And user validates the response with JSON schema

 