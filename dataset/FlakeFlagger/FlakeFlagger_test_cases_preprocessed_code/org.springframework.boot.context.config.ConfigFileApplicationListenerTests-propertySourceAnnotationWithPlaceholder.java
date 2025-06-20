@Test public void propertySourceAnnotationWithPlaceholder() throws Exception {
assertThat(property,equalTo("fromspecificlocation"));
assertThat(context.getEnvironment(),containsPropertySource("class path resource " + "[specificlocation.properties]"));
}