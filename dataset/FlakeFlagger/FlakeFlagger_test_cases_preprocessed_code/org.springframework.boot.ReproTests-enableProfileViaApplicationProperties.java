@Test public void enableProfileViaApplicationProperties() throws Exception {
assertThat(context.getEnvironment().acceptsProfiles("dev"),equalTo(true));
assertThat(context.getEnvironment().acceptsProfiles("a"),equalTo(true));
}