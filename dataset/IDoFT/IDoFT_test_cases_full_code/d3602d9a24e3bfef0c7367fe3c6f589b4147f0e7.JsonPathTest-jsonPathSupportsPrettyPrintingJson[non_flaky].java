@Test public void jsonPathSupportsPrettyPrintingJson(){
  final String prettyJson=JsonPath.with(JSON2).prettyPrint();
  assertThat(prettyJson,equalTo("[\n    {\n        \"email\": \"name1@mail.com\",\n        \"alias\": \"name one\",\n        \"phone\": \"3456789\"\n    },\n    {\n        \"email\": \"name2@mail.com\",\n        \"alias\": \"name two\",\n        \"phone\": \"1234567\"\n    },\n    {\n        \"email\": \"name3@mail.com\",\n        \"alias\": \"name three\",\n        \"phone\": \"2345678\"\n    }\n]"));
}
