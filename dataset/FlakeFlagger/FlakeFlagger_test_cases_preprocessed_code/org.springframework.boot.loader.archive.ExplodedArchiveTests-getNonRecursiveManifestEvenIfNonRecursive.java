@Test public void getNonRecursiveManifestEvenIfNonRecursive() throws Exception {
ExplodedArchive archive=new ExplodedArchive(new File("src/test/resources/root"),false);//RO
assertNotNull(archive.getManifest());
assertThat(entries.size(),equalTo(3));
}