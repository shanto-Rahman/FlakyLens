@Test public void testGetServices(){
assertSame(response,hostService.getServices(httpHeaders,uriInfo));
}