@Test public void loadCustomResource() throws Exception {
if (location.equals("classpath:/custom.properties")) {
}
assertThat(property,equalTo("fromcustom"));
}