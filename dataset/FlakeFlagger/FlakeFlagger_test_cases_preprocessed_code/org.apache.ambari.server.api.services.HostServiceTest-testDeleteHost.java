@Test public void testDeleteHost(){
assertSame(response,hostService.deleteHost(httpHeaders,uriInfo,hostName));
}