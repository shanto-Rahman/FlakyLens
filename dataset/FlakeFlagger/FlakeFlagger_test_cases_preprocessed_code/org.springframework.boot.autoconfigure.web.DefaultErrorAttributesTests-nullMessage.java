@Test public void nullMessage() throws Exception {
assertThat(attributes.get("exception"),equalTo((Object)RuntimeException.class.getName()));
assertThat(attributes.get("message"),equalTo((Object)"Test"));
}