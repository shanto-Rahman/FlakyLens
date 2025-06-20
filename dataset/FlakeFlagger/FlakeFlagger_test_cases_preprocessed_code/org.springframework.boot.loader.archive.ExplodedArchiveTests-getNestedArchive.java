@Test public void getNestedArchive() throws Exception {
assertThat(nested.getUrl().toString(),equalTo("jar:" + this.rootFolder.toURI() + "nested.jar!/"));
}