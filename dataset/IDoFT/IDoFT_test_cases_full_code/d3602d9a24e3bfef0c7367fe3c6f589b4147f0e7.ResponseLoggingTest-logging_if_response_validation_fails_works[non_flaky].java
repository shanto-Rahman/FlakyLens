@Test public void logging_if_response_validation_fails_works() throws JSONException {
  try {
    RestAssuredWebTestClient.given().standaloneSetup(new PostController()).param("name","Johan").when().post("/greetingPost").then().log().ifValidationFails().body("id",equalTo(1)).body("content",equalTo("Hello, Johan2!"));
    fail("Should throw AssertionError");
  }
 catch (  AssertionError e) {
    String writerString=writer.toString();
    String headerString=String.format("200%n" + "Content-Type: application/json;charset=UTF-8%n" + "Content-Length: 34%n"+ "%n");
    assertThat(writerString,startsWith(headerString));
    LoggingIfValidationFailsTest.assertJSONEqual(writerString.replace(headerString,"").trim(),"{" + "\n    \"id\": 1,\n" + "    \"content\": \"Hello, Johan!\""+ "\n"+ "}%n");
  }
}
