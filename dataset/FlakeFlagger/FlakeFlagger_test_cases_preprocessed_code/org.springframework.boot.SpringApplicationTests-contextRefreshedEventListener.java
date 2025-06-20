@Test public void contextRefreshedEventListener() throws Exception {
assertThat(this.context,sameInstance(reference.get()));
assertThat(getEnvironment().getProperty("foo"),equalTo("bar"));
}