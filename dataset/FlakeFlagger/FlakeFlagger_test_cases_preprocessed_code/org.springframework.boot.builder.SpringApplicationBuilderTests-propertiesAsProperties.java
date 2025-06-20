@Test public void propertiesAsProperties() throws Exception {
assertThat(this.context.getEnvironment().getProperty("bar"),is(equalTo("foo")));
}