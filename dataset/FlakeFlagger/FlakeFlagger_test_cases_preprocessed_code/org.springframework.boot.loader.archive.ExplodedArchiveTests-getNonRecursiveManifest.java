@Test public void getNonRecursiveManifest() throws Exception {
ExplodedArchive archive=new ExplodedArchive(new File("src/test/resources/root"));//RO
assertNotNull(archive.getManifest());
assertThat(entries.size(),equalTo(4));
}