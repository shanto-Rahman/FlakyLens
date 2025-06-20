@Test public void testPrettyPrintNoLineSeparator(){
  JsonFormatter formatter=new JsonFormatter(objectMapper,true,false);
  assertThat(formatter.toJson(map)).isEqualTo(String.format("{%n" + "  \"hobbies\" : [ \"Reading\", \"Biking\", \"Snorkeling\" ],%n" + "  \"name\" : \"Jim\"%n"+ "}"));
}
