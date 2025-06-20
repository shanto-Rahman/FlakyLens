@Test public void badClientRequest() throws Exception {
  this.mvc.perform(get("/api/c1/oops")).andExpect(status().is4xxClientError());
  assertThat(this.registry.get("http.server.requests").tags("status","400").timer().count()).isEqualTo(1L);
}
