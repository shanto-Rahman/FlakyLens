@Test public void linksToOtherEndpointsWithRestrictedAccess(){
  given(tokenValidator.validate(any())).willReturn(Mono.empty());
  given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(Mono.just(AccessLevel.RESTRICTED));
  this.contextRunner.run(withWebTestClient((client) -> client.get().uri("/cfApplication").accept(MediaType.APPLICATION_JSON).header("Authorization","bearer " + mockAccessToken()).exchange().expectStatus().isOk().expectBody().jsonPath("_links.length()").isEqualTo(2).jsonPath("_links.self.href").isNotEmpty().jsonPath("_links.self.templated").isEqualTo(false).jsonPath("_links.info.href").isNotEmpty().jsonPath("_links.info.templated").isEqualTo(false).jsonPath("_links.env").doesNotExist().jsonPath("_links.test").doesNotExist().jsonPath("_links.test-part").doesNotExist()));
}
