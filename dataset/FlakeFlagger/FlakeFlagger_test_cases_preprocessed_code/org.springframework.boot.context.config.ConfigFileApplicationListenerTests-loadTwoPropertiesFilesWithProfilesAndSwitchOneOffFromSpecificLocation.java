@Test public void loadTwoPropertiesFilesWithProfilesAndSwitchOneOffFromSpecificLocation() throws Exception {
assertEquals("myprofile",StringUtils.arrayToCommaDelimitedString(this.environment.getActiveProfiles()));
assertThat(property,equalTo("frompropertiesfile"));
}