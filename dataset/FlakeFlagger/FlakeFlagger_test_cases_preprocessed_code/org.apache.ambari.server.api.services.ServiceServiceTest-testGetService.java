@Test public void testGetService(){
assertSame(response,hostService.getService(httpHeaders,uriInfo,serviceName));
}