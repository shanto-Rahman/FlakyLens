@Test public void operationWithSecurityInterceptorSuccess(){
  given(tokenValidator.validate(any())).willReturn(Mono.empty());
  given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(Mono.just(AccessLevel.FULL));
  this.contextRunner.run(withWebTestClient((client) -> client.get().uri("/cfApplication/test").accept(MediaType.APPLICATION_JSON).header("Authorization","bearer " + mockAccessToken()).exchange().expectStatus().isEqualTo(HttpStatus.OK)));
}
