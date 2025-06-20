@Test public void propertySourceAnnotationInProfile() throws Exception {
assertThat(property,equalTo("frompropertiesfile"));
assertThat(context.getEnvironment(),containsPropertySource("class path resource " + "[enableprofile.properties]"));
assertThat(context.getEnvironment(),not(containsPropertySource("classpath:/" + "enableprofile-myprofile.properties")));
}