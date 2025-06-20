@Test public void renderTemplate() throws Exception {
assertThat(writer.toString(),containsString("Hello World"));
}