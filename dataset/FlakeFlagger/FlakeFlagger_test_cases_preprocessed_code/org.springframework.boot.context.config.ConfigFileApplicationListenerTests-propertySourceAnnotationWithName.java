@Test public void propertySourceAnnotationWithName() throws Exception {
assertThat(property,equalTo("fromspecificlocation"));
assertThat(context.getEnvironment(),containsPropertySource("foo"));
}