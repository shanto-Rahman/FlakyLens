@Test public void linksToOtherEndpointsWithRestrictedAccess(){
given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(AccessLevel.RESTRICTED);//RW
}