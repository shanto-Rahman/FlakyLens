@Test public void testCreateComponent(){
assertSame(response,componentService.createComponent("body",httpHeaders,uriInfo,componentName));
}