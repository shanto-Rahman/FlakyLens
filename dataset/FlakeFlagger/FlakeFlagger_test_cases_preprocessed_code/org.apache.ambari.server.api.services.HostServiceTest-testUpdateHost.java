@Test public void testUpdateHost(){
assertSame(response,hostService.updateHost("body",httpHeaders,uriInfo,hostName));
}