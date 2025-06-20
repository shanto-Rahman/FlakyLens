@Test public void farewellInputShouldReturnPropertyFromSecondFile(){
  this.webClient.get().uri("/api/farewell").exchange().expectStatus().isOk().expectBody().jsonPath("content").isEqualTo("Bye from path!");
}
