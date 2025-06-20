@Test public void testPrettyPrintWithLineSeparator(){
  JsonFormatter formatter=new JsonFormatter(objectMapper,true,true);
  assertThat(formatter.toJson(map)).isEqualTo(String.format("{%n" + "  \"hobbies\" : [ \"Reading\", \"Biking\", \"Snorkeling\" ],%n" + "  \"name\" : \"Jim\"%n"+ "}%n"));
}
