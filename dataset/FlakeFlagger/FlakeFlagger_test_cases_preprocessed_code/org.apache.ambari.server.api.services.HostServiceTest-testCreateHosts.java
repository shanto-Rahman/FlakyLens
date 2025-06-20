@Test public void testCreateHosts(){
assertSame(response,hostService.createHosts(body,httpHeaders,uriInfo));
}