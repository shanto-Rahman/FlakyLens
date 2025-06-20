@Test public void resolveResourcesFromArchive() throws Exception {
assertTrue(loader.getResources("demo/Application.java").hasMoreElements());
}