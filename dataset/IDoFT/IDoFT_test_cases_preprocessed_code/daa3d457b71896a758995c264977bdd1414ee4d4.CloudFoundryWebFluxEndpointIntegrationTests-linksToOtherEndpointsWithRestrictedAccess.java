@Test public void linksToOtherEndpointsWithRestrictedAccess(){
given(tokenValidator.validate(any())).willReturn(Mono.empty());//RW
given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(Mono.just(AccessLevel.RESTRICTED));//RW
}