@Test public void renderNonWebAppTemplate() throws Exception {
assertThat(writer.toString(),containsString("Hello World"));
}