@Test public void createFromMap() throws Exception {
assertThat(clone.get("foo"),equalTo("bar"));
assertThat(clone.get("baz"),nullValue());
}