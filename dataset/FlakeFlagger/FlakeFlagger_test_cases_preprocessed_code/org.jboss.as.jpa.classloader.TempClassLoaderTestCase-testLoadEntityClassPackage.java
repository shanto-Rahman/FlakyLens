@Test public void testLoadEntityClassPackage() throws Exception {
assertNotNull("could not load package for entity class that came from NewTempClassLoader",entityClass.getPackage());
}