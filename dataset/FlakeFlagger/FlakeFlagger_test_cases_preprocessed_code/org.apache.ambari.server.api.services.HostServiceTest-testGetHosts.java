@Test public void testGetHosts(){
assertSame(response,hostService.getHosts(httpHeaders,uriInfo));
}