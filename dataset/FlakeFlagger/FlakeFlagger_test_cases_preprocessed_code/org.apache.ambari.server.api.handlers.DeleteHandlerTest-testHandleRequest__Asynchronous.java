@Test public void testHandleRequest__Asynchronous(){
assertNotNull(result);
assertEquals(2,tree.getChildren().size());
assertEquals(2,resourcesNode.getChildren().size());
if (r == resource1 && !foundResource1) {
if (r == resource2 && !foundResource2) {
fail();
}
}
assertNotNull(statusNode);
assertEquals(0,statusNode.getChildren().size());
assertSame(requestResource,statusNode.getObject());
assertEquals("http://some.host.com/clusters/cluster1/requests/requestID",statusNode.getProperty("href"));
}