@Test public void getMissingEntryUrl() throws Exception {
assertThat(url.toString(),equalTo("jar:" + this.rootJarFile.toURI() + "!/missing.dat"));
}