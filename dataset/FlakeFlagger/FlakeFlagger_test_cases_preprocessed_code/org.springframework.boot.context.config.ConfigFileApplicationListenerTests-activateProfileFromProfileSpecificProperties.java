@Test public void activateProfileFromProfileSpecificProperties() throws Exception {
assertThat(context.getEnvironment(),acceptsProfiles("includeprofile"));
assertThat(context.getEnvironment(),acceptsProfiles("specific"));
assertThat(context.getEnvironment(),acceptsProfiles("morespecific"));
assertThat(context.getEnvironment(),acceptsProfiles("yetmorespecific"));
assertThat(context.getEnvironment(),not(acceptsProfiles("missing")));
}