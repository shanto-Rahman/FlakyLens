@Test public void pretty_printing_works(){
assertThat(string,equalTo("{\n" + "    \"data\": [\n" + "        {\n"+ "            \"uid\": 10,\n"+ "            \"name\": \"abc\"\n"+ "        }\n"+ "    ]\n"+ "}"));
}