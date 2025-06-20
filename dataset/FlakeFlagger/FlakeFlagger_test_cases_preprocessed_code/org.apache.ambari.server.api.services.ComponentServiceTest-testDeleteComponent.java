@Test public void testDeleteComponent(){
assertSame(response,componentService.deleteComponent(httpHeaders,uriInfo,componentName));
}