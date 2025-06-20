@Test public void operationWithSecurityInterceptorForbidden(){
  given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(AccessLevel.RESTRICTED);
  load(TestEndpointConfiguration.class,(client) -> client.get().uri("/cfApplication/test").accept(MediaType.APPLICATION_JSON).header("Authorization","bearer " + mockAccessToken()).exchange().expectStatus().isEqualTo(HttpStatus.FORBIDDEN));
}
