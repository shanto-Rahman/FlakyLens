@Test public void propertySourceAnnotationAndNonActiveProfile() throws Exception {
assertThat(property,equalTo("fromapplicationproperties"));
assertThat(context.getEnvironment(),not(containsPropertySource("classpath:" + "/enableprofile-myprofile.properties")));
}