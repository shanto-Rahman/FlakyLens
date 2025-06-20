@Test public void testCreateClusterResources() throws Exception {
Assert.assertNotNull(lastEvent);
Assert.assertEquals(Resource.Type.Cluster,lastEvent.getResourceType());
Assert.assertEquals(ResourceProviderEvent.Type.Create,lastEvent.getType());
Assert.assertEquals(request,lastEvent.getRequest());
Assert.assertNull(lastEvent.getPredicate());
}