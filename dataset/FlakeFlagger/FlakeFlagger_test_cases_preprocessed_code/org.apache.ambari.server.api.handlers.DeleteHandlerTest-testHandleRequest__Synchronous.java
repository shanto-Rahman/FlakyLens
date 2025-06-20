@Test public void testHandleRequest__Synchronous(){
assertNotNull(result);
assertEquals(1,tree.getChildren().size());
assertEquals(2,resourcesNode.getChildren().size());
if (r == resource1 && !foundResource1) {
if (r == resource2 && !foundResource2) {
fail();
}
}
}