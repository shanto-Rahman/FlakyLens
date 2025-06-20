@Test public void addReplacesExisting() throws Exception {
assertThat(mappings.add("foo","baz"),equalTo("bar"));
}