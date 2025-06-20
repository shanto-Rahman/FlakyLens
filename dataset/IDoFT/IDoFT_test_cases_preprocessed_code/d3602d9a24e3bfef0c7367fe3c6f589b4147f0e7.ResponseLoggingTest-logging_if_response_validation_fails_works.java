@Test public void logging_if_response_validation_fails_works(){
fail("Should throw AssertionError");
assertThat(writer.toString(),equalTo(String.format("200%n" + "Content-Type: application/json;charset=UTF-8%n" + "Content-Length: 34%n"+ "%n"+ "{"+ "\n    \"id\": 1,\n"+ "    \"content\": \"Hello, Johan!\""+ "\n"+ "}%n")));
}