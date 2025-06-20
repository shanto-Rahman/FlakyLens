@Test public void testDeleteHostComponent(){
assertSame(response,hostComponentService.deleteHostComponent(httpHeaders,uriInfo,hostComponentName));
}