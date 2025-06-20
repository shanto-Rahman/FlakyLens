@Test public void testUpdateService(){
assertSame(response,hostService.updateService("body",httpHeaders,uriInfo,serviceName));
}