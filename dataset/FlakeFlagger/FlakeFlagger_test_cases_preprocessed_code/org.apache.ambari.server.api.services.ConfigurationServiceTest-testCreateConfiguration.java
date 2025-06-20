@Test public void testCreateConfiguration(){
assertSame(response,hostService.createConfigurations(body,httpHeaders,uriInfo));
}