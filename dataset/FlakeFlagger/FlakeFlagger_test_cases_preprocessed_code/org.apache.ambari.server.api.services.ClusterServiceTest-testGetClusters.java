@Test public void testGetClusters(){
assertSame(response,clusterService.getClusters(httpHeaders,uriInfo));
}