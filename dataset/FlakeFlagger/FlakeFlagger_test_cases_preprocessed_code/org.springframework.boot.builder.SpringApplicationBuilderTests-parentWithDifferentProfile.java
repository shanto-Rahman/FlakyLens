@Test public void parentWithDifferentProfile() throws Exception {
assertThat(this.context.getEnvironment().acceptsProfiles("node","admin"),is(true));
assertThat(this.context.getParent().getEnvironment().acceptsProfiles("node","parent"),is(true));
assertThat(this.context.getParent().getEnvironment().acceptsProfiles("admin"),is(false));
}