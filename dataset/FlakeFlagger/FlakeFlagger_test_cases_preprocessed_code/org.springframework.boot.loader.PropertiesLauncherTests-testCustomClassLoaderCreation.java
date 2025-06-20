@Test public void testCustomClassLoaderCreation() throws Exception {
assertNotNull(loader);
assertEquals(TestLoader.class.getName(),loader.getClass().getName());
}