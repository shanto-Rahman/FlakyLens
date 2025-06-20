@Test public void testGetHostComponent(){
assertSame(response,hostComponentService.getHostComponent(httpHeaders,uriInfo,hostComponentName));
}