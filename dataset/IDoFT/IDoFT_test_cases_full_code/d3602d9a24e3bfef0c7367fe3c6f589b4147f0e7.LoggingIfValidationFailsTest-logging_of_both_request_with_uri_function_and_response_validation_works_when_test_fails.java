@Test public void logging_of_both_request_with_uri_function_and_response_validation_works_when_test_fails(){
  RestAssuredWebTestClient.config=new RestAssuredWebTestClientConfig().logConfig(new LogConfig(captor,true).enableLoggingOfRequestAndResponseIfValidationFails());
  try {
    given().standaloneSetup(new PostController()).contentType(ContentType.URLENC).when().post(uriBuilder -> uriBuilder.path("/greetingPost").queryParam("name","Johan").build()).then().body("id",equalTo(1)).body("content",equalTo("Hello, Johan2!"));
    fail("Should throw AssertionError");
  }
 catch (  AssertionError e) {
    assertThat(writer.toString(),containsString(UriUtils.encode("Request from uri function",defaultCharset())));
    assertThat(writer.toString(),containsString(String.format("Request method:\tPOST%n")));
    assertThat(writer.toString(),containsString(String.format("Proxy:\t\t\t<none>%n" + "Request params:\t<none>%n" + "Query params:\t<none>%n"+ "Form params:\t<none>%n"+ "Path params:\t<none>%n"+ "Headers:\t\tContent-Type=application/x-www-form-urlencoded%n"+ "Cookies:\t\t<none>%n"+ "Multiparts:\t\t<none>%n"+ "Body:\t\t\t<none>%n"+ "%n"+ "200%n"+ "Content-Type: application/json;charset=UTF-8%n"+ "Content-Length: 34%n"+ "%n"+ "{\n"+ "    \"id\": 1,\n"+ "    \"content\": \"Hello, Johan!\"\n"+ "}%n")));
  }
}
