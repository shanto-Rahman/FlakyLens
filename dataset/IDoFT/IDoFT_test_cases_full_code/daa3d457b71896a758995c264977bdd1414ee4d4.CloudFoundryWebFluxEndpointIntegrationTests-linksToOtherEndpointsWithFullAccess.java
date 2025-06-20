@Test public void linksToOtherEndpointsWithFullAccess(){
  given(tokenValidator.validate(any())).willReturn(Mono.empty());
  given(securityService.getAccessLevel(any(),eq("app-id"))).willReturn(Mono.just(AccessLevel.FULL));
  this.contextRunner.run(withWebTestClient((client) -> client.get().uri("/cfApplication").accept(MediaType.APPLICATION_JSON).header("Authorization","bearer " + mockAccessToken()).exchange().expectStatus().isOk().expectBody().jsonPath("_links.length()").isEqualTo(5).jsonPath("_links.self.href").isNotEmpty().jsonPath("_links.self.templated").isEqualTo(false).jsonPath("_links.info.href").isNotEmpty().jsonPath("_links.info.templated").isEqualTo(false).jsonPath("_links.env.href").isNotEmpty().jsonPath("_links.env.templated").isEqualTo(false).jsonPath("_links.test.href").isNotEmpty().jsonPath("_links.test.templated").isEqualTo(false).jsonPath("_links.test-part.href").isNotEmpty().jsonPath("_links.test-part.templated").isEqualTo(true)));
}
