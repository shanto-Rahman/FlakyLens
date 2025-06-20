@Test public void testGetHost(){
assertSame(response,hostService.getHost(httpHeaders,uriInfo,hostName));
}