@Test public void testDeleteCluster(){
assertSame(response,clusterService.deleteCluster(httpHeaders,uriInfo,clusterName));
}