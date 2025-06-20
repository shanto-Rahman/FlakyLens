@Test public void whenNoValuesListedForSerlvets_generateJsonRequest(){
assertThat(parser.parse(selector.getRequest()),equalTo(parser.parse(compressedJsonForm(EXPECTED_ALL_SERVLET_VALUES_JSON_REQUEST))));
}