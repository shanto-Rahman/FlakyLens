@Test public void jsonPathSupportsPrettyPrintingJson(){
  final String prettyJson=JsonPath.with(JSON2).prettyPrint();
  assertThat(prettyJson,equalTo("[\n    {\n        \"phone\": \"3456789\",\n        \"alias\": \"name one\",\n        \"email\": \"name1@mail.com\"\n    },\n    {\n        \"phone\": \"1234567\",\n        \"alias\": \"name two\",\n        \"email\": \"name2@mail.com\"\n    },\n    {\n        \"phone\": \"2345678\",\n        \"alias\": \"name three\",\n        \"email\": \"name3@mail.com\"\n    }\n]"));
}
