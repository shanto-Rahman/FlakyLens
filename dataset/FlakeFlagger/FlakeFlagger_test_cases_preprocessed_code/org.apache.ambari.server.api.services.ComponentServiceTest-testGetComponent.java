@Test public void testGetComponent(){
assertSame(response,componentService.getComponent(httpHeaders,uriInfo,componentName));
}