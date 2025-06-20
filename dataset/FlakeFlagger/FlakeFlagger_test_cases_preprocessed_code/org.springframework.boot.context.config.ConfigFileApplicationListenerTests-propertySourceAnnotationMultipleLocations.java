@Test public void propertySourceAnnotationMultipleLocations() throws Exception {
assertThat(property,equalTo("frommorepropertiesfile"));
assertThat(context.getEnvironment(),containsPropertySource("class path resource " + "[specificlocation.properties]"));
}