@Test public void includeTimeStamp() throws Exception {
assertThat(attributes.get("timestamp"),instanceOf(Date.class));
}