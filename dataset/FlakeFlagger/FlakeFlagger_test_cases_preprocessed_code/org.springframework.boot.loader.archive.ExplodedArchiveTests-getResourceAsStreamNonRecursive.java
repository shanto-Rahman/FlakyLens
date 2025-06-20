@Test public void getResourceAsStreamNonRecursive() throws Exception {
ExplodedArchive archive=new ExplodedArchive(new File("src/test/resources/root"),false);//RO
assertNotNull(archive.getManifest());
assertNotNull(loader.getResourceAsStream("META-INF/spring/application.xml"));
}