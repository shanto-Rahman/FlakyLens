@Test public void loadTwoPropertiesFilesWithProfiles() throws Exception {
assertEquals("other",StringUtils.arrayToCommaDelimitedString(this.environment.getActiveProfiles()));
assertThat(property,equalTo("fromotherpropertiesfile"));
}