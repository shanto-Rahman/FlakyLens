@Test public void propertySourceAnnotationMultipleLocationsAndName() throws Exception {
assertThat(property,equalTo("frommorepropertiesfile"));
assertThat(context.getEnvironment(),containsPropertySource("foo"));
}