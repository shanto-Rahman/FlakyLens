@Test void getUsingCustomMediaType() throws IOException {
  this.testClient.get().uri("http://localhost/employees/1").accept(FRODO_MEDIATYPE).exchange().expectStatus().isOk().expectHeader().contentType(FRODO_MEDIATYPE.toString()).expectBody(String.class).isEqualTo(read(new ClassPathResource("webflux-frodo.json",getClass())));
}
