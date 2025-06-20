@Test public void testUpdateHostComponent(){
assertSame(response,hostComponentService.updateHostComponent("body",httpHeaders,uriInfo,hostComponentName));
}