@Test public void prefixedRelaxed() throws Exception {
assertThat(this.resolver.containsProperty("b"),equalTo(true));
assertThat(this.resolver.getProperty("b"),equalTo("test"));
assertThat(this.resolver.getProperty("foo-bar"),equalTo("spam"));
}