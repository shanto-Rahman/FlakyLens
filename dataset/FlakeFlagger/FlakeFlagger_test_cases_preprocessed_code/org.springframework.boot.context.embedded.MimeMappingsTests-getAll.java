@Test public void getAll() throws Exception {
assertThat(mappingList.get(0).getExtension(),equalTo("foo"));
assertThat(mappingList.get(0).getMimeType(),equalTo("bar"));
assertThat(mappingList.get(1).getExtension(),equalTo("baz"));
assertThat(mappingList.get(1).getMimeType(),equalTo("boo"));
}