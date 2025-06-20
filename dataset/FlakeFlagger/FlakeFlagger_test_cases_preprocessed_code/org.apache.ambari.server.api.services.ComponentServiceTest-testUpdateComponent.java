@Test public void testUpdateComponent(){
assertSame(response,componentService.updateComponent("body",httpHeaders,uriInfo,componentName));
}