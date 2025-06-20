@Test public void jsonp() throws JSONException {
assertThat(jsonp.replace(test,"")).isEqualTo(testJSON.replace(expected,""));
}