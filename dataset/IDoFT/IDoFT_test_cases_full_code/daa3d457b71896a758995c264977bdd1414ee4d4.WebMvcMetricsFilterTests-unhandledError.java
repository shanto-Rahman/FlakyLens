@Test public void unhandledError(){
  assertThatCode(() -> this.mvc.perform(get("/api/c1/unhandledError/10")).andExpect(status().isOk())).hasRootCauseInstanceOf(RuntimeException.class);
  assertThat(this.registry.get("http.server.requests").tags("exception","RuntimeException").timer().count()).isEqualTo(1L);
}
