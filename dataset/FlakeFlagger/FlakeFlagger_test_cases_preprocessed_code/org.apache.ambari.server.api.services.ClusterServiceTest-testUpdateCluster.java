@Test public void testUpdateCluster(){
assertSame(response,clusterService.updateCluster("body",httpHeaders,uriInfo,clusterName));
}