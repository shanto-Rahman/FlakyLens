@Test public void generateJsonRequest(){
assertThat(selector.getRequest(),equalTo(compressedJsonForm(EXPECTED_JSON_REQUEST)));
}