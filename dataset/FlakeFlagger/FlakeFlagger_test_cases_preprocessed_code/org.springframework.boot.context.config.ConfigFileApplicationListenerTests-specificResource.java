@Test public void specificResource() throws Exception {
assertThat(property,equalTo("fromspecificlocation"));
assertThat(this.environment,containsPropertySource("applicationConfig: " + "[classpath:specificlocation.properties]"));
assertThat(this.environment,containsPropertySource("applicationConfig: " + "[classpath:/application.properties]"));
assertThat(this.environment.getProperty("foo"),equalTo("bucket"));
}