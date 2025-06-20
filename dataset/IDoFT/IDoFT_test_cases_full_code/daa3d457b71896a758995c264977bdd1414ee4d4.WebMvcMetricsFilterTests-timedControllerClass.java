@Test public void timedControllerClass() throws Exception {
  this.mvc.perform(get("/api/c2/10")).andExpect(status().isOk());
  assertThat(this.registry.get("http.server.requests").tags("status","200").timer().count()).isEqualTo(1L);
}
