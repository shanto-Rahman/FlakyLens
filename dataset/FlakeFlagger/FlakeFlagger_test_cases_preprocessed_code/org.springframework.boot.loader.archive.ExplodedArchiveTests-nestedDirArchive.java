@Test public void nestedDirArchive() throws Exception {
assertThat(nestedEntries.size(),equalTo(1));
assertThat(nested.getUrl().toString(),equalTo("file:" + this.rootFolder.toURI().getPath() + "d/"));
}