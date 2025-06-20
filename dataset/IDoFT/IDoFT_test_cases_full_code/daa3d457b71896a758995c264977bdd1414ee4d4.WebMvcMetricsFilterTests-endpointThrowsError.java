@Test public void endpointThrowsError() throws Exception {
  this.mvc.perform(get("/api/c1/error/10")).andExpect(status().is4xxClientError());
  assertThat(this.registry.get("http.server.requests").tags("status","422").timer().count()).isEqualTo(1L);
}
