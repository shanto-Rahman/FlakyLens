@Test public void operationWithSecurityInterceptorForbidden(){
given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(AccessLevel.RESTRICTED);//RW
}