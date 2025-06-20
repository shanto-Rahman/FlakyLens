@Test public void getManifestEntry() throws Exception {
assertThat(manifest.getMainAttributes().getValue("Built-By"),equalTo("j1"));
}