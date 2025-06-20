@Test public void whenNoValuesListedForSerlvets_generateJsonRequest(){
assertThat(selector.getRequest(),equalTo(compressedJsonForm(EXPECTED_ALL_SERVLET_VALUES_JSON_REQUEST)));
}