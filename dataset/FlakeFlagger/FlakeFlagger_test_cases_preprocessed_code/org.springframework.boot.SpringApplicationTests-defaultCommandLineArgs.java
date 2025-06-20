@Test public void defaultCommandLineArgs() throws Exception {
assertThat(this.context,instanceOf(AnnotationConfigApplicationContext.class));
assertThat(getEnvironment().getProperty("bar"),equalTo("foo"));
assertThat(getEnvironment().getProperty("baz"),equalTo(""));
}