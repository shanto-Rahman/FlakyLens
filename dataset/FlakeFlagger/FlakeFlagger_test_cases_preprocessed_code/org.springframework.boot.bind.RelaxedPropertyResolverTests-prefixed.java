@Test public void prefixed() throws Exception {
assertThat(this.resolver.containsProperty("d"),equalTo(true));
assertThat(this.resolver.getProperty("d"),equalTo("test"));
}