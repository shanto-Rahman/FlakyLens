@Test public void propertiesAsMap() throws Exception {
assertThat(this.context.getEnvironment().getProperty("bar"),is(equalTo("foo")));
}