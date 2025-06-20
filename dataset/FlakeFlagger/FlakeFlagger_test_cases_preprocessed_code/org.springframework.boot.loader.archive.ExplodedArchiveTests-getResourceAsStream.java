@Test public void getResourceAsStream() throws Exception {
ExplodedArchive archive=new ExplodedArchive(new File("src/test/resources/root"));//RO
assertNotNull(archive.getManifest());
assertNotNull(loader.getResourceAsStream("META-INF/spring/application.xml"));
}