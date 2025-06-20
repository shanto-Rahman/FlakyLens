@Test public void remove() throws Exception {
assertThat(mappings.remove("foo"),equalTo("bar"));
assertThat(mappings.remove("foo"),nullValue());
}