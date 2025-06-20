@Test public void servletMessage() throws Exception {
assertThat(attributes.get("exception"),nullValue());
assertThat(attributes.get("message"),equalTo((Object)"Test"));
}