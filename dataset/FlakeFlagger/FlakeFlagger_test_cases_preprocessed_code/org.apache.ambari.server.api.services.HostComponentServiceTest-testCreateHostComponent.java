@Test public void testCreateHostComponent(){
assertSame(response,hostComponentService.createHostComponent("body",httpHeaders,uriInfo,hostComponentName));
}