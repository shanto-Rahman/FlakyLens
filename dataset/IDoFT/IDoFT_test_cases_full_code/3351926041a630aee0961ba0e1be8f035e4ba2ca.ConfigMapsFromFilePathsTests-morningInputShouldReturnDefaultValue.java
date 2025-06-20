@Test public void morningInputShouldReturnDefaultValue(){
  this.webClient.get().uri("/api/morning").exchange().expectStatus().isOk().expectBody().jsonPath("content").isEqualTo("Good morning, World!");
}
