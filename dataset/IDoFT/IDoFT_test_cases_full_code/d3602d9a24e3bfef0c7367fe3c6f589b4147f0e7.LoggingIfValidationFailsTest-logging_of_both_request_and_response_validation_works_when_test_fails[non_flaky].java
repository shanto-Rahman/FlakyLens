@Test public void logging_of_both_request_and_response_validation_works_when_test_fails() throws JSONException {
  RestAssuredWebTestClient.config=new RestAssuredWebTestClientConfig().logConfig(new LogConfig(captor,true).enableLoggingOfRequestAndResponseIfValidationFails());
  try {
    given().standaloneSetup(new PostController()).param("name","Johan").when().post("/greetingPost").then().body("id",equalTo(1)).body("content",equalTo("Hello, Johan2!"));
    fail("Should throw AssertionError");
  }
 catch (  AssertionError e) {
    String writerString1=writer.toString();
    String headerString1=String.format("Request method:\tPOST%n" + "Request URI:\thttp://localhost:8080/greetingPost%n" + "Proxy:\t\t\t<none>%n"+ "Request params:\tname=Johan%n"+ "Query params:\t<none>%n"+ "Form params:\t<none>%n"+ "Path params:\t<none>%n"+ "Headers:\t\tContent-Type=application/x-www-form-urlencoded;charset=%s%n"+ "Cookies:\t\t<none>%n"+ "Multiparts:\t\t<none>%n"+ "Body:\t\t\t<none>%n"+ "%n"+ "200%n"+ "Content-Type: application/json;charset=UTF-8%n"+ "Content-Length: 34%n"+ "%n",config().getEncoderConfig().defaultContentCharset());
    assertThat(writerString1,startsWith(headerString1));
    assertJSONEqual(writerString1.replace(headerString1,"").trim(),"{\n" + "    \"id\": 1,\n" + "    \"content\": \"Hello, Johan!\"\n"+ "}%n");
  }
}
