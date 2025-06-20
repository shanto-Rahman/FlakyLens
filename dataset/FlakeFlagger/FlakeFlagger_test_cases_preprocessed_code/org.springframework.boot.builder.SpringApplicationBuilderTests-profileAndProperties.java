@Test public void profileAndProperties() throws Exception {
assertThat(this.context,is(instanceOf(StaticApplicationContext.class)));
assertThat(this.context.getEnvironment().getProperty("foo"),is(equalTo("bucket")));
assertThat(this.context.getEnvironment().acceptsProfiles("foo"),is(true));
}