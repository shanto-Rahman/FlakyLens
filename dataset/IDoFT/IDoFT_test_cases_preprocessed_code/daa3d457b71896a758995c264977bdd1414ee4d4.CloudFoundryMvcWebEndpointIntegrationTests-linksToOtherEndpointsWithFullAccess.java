@Test public void linksToOtherEndpointsWithFullAccess(){
given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(AccessLevel.FULL);//RW
}