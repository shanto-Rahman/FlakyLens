@SuppressWarnings("unchecked") @Test public void restTemplateIsInstrumented(){
  MockRestServiceServer server=MockRestServiceServer.bindTo(this.external).build();
  server.expect(once(),requestTo("/api/external")).andExpect(method(HttpMethod.GET)).andRespond(withSuccess("{\"message\": \"hello\"}",MediaType.APPLICATION_JSON));
  assertThat(this.external.getForObject("/api/external",Map.class)).containsKey("message");
  assertThat(this.registry.get("http.client.requests").timer().count()).isEqualTo(1);
}
