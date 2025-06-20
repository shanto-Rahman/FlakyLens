@Test() public void testDirectResourceRetrieval(){
assertNotNull("Resource in META-INF should be accessible",manifestResource);
assertNotNull("Nested resource should be also accessible",nestedManifestResource);
assertNull("Resource in the root of WAR shouldn't be accessible",nonManifestResource);
}