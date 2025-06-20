@Test public void yamlSetsProfiles() throws Exception {
assertEquals("dev",StringUtils.arrayToCommaDelimitedString(this.environment.getActiveProfiles()));
assertThat(Arrays.asList(this.environment.getActiveProfiles()),contains("dev"));
assertThat(property,equalTo("fromdevprofile"));
assertEquals(2,sources.size());
if (source instanceof EnumerableCompositePropertySource) {
}
assertThat(names,contains("applicationConfig: [classpath:/testsetprofiles.yml]#dev","applicationConfig: [classpath:/testsetprofiles.yml]"));
}