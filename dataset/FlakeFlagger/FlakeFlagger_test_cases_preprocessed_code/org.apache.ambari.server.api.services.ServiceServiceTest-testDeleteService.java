@Test public void testDeleteService(){
assertSame(response,hostService.deleteService(httpHeaders,uriInfo,serviceName));
}