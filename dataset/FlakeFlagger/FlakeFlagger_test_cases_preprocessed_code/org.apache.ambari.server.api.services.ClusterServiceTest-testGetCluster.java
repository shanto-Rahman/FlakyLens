@Test public void testGetCluster(){
assertSame(response,clusterService.getCluster(httpHeaders,uriInfo,clusterName));
}