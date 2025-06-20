@Test public void createFromExisting() throws Exception {
assertThat(clone.get("foo"),equalTo("bar"));
assertThat(clone.get("baz"),nullValue());
}