@Test public void testLoadResources() throws IOException {
assertNotNull(tempClassLoader.getResource(resource));
assertTrue(tempClassLoader.getResources(resource).hasMoreElements());
assertNotNull(resourceStream);
}