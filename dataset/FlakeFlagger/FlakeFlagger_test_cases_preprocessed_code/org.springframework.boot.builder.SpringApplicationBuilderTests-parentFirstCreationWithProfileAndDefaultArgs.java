@Test public void parentFirstCreationWithProfileAndDefaultArgs() throws Exception {
assertThat(this.context.getEnvironment().acceptsProfiles("node"),is(true));
assertThat(this.context.getEnvironment().getProperty("transport"),is(equalTo("redis")));
assertThat(this.context.getParent().getEnvironment().acceptsProfiles("node"),is(true));
assertThat(this.context.getParent().getEnvironment().getProperty("transport"),is(equalTo("redis")));
assertThat(this.context.getEnvironment().getProperty("bar"),is(equalTo("spam")));
}