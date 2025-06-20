@Test public void logging_if_response_validation_fails_works(){
  try {
    RestAssuredWebTestClient.given().standaloneSetup(new PostController()).param("name","Johan").when().post("/greetingPost").then().log().ifValidationFails().body("id",equalTo(1)).body("content",equalTo("Hello, Johan2!"));
    fail("Should throw AssertionError");
  }
 catch (  AssertionError e) {
    assertThat(writer.toString(),equalTo(String.format("200%n" + "Content-Type: application/json;charset=UTF-8%n" + "Content-Length: 34%n"+ "%n"+ "{"+ "\n    \"id\": 1,\n"+ "    \"content\": \"Hello, Johan!\""+ "\n"+ "}%n")));
  }
}
