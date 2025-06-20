@Test public void generateJsonRequest(){
assertThat(parser.parse(selector.getRequest()),equalTo(parser.parse(compressedJsonForm(EXPECTED_JSON_REQUEST))));
}