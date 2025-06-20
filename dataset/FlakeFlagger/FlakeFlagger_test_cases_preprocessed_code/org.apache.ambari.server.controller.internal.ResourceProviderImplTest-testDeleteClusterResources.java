@Test public void testDeleteClusterResources() throws Exception {
Assert.assertNotNull(lastEvent);
Assert.assertEquals(Resource.Type.Cluster,lastEvent.getResourceType());
Assert.assertEquals(ResourceProviderEvent.Type.Delete,lastEvent.getType());
Assert.assertEquals(predicate,lastEvent.getPredicate());
Assert.assertNull(lastEvent.getRequest());
}