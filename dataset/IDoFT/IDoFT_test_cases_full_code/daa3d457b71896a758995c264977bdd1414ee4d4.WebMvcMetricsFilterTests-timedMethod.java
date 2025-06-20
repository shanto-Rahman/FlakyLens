@Test public void timedMethod() throws Exception {
  this.mvc.perform(get("/api/c1/10")).andExpect(status().isOk());
  assertThat(this.registry.get("http.server.requests").tags("status","200","uri","/api/c1/{id}","public","true").timer().count()).isEqualTo(1);
}
