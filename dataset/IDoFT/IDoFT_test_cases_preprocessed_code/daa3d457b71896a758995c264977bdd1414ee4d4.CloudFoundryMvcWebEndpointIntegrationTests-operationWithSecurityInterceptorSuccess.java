@Test public void operationWithSecurityInterceptorSuccess(){
given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(AccessLevel.FULL);//RW
}