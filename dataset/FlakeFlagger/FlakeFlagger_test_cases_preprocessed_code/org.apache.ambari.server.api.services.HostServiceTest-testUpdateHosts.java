@Test public void testUpdateHosts(){
assertSame(response,hostService.updateHosts("body",httpHeaders,uriInfo));
}