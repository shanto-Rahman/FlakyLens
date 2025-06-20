@Test public void testCreateHost(){
assertSame(response,hostService.createHost(null,httpHeaders,uriInfo,hostName));
}