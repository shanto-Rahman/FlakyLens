@Test public void regexBasedRequestMapping() throws Exception {
  this.mvc.perform(get("/api/c1/regex/.abc")).andExpect(status().isOk());
  assertThat(this.registry.get("http.server.requests").tags("uri","/api/c1/regex/{id:\\.[a-z]+}").timer().count()).isEqualTo(1L);
}
