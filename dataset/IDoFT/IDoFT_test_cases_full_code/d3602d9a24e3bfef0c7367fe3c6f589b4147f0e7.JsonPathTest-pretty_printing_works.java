@Test public void pretty_printing_works(){
  String json="{\"data\": [{" + "         \"uid\": 10,\n" + "         \"name\": \"abc\"\n"+ "      }\n"+ "   ]\n"+ "}";
  final JsonPath jsonPath=new JsonPath(json);
  final String string=jsonPath.prettyPrint();
  assertThat(string,equalTo("{\n" + "    \"data\": [\n" + "        {\n"+ "            \"uid\": 10,\n"+ "            \"name\": \"abc\"\n"+ "        }\n"+ "    ]\n"+ "}"));
}
