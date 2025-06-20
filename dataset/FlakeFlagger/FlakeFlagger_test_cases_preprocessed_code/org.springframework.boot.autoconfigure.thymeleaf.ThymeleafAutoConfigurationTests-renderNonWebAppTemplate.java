@Test public void renderNonWebAppTemplate() throws Exception {
assertEquals(0,context.getBeanNamesForType(ViewResolver.class).length);
assertThat(result,containsString("Hello World"));
}