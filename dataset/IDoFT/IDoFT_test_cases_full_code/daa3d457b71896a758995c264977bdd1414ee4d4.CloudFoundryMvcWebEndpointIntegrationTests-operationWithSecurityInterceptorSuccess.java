@Test public void operationWithSecurityInterceptorSuccess(){
  given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(AccessLevel.FULL);
  load(TestEndpointConfiguration.class,(client) -> client.get().uri("/cfApplication/test").accept(MediaType.APPLICATION_JSON).header("Authorization","bearer " + mockAccessToken()).exchange().expectStatus().isEqualTo(HttpStatus.OK));
}
