@Test public void testMetadataConfiguration() throws Throwable {
assertNotNull(controller);
assertNotNull(repository);
assertNotNull(ids);
assertNotNull(piId);
assertNotNull(repository.getResourceAdapter(piId));
}