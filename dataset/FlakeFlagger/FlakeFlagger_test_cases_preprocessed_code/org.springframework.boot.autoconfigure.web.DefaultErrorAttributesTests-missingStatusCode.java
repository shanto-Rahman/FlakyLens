@Test public void missingStatusCode() throws Exception {
assertThat(attributes.get("error"),equalTo((Object)"None"));
assertThat(attributes.get("status"),equalTo((Object)999));
}