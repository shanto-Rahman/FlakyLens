@Test public void subclassedTimedMethod() throws Exception {
  this.mvc.perform(get("/api/c1/metaTimed/10")).andExpect(status().isOk());
  assertThat(this.registry.get("http.server.requests").tags("status","200","uri","/api/c1/metaTimed/{id}").timer().count()).isEqualTo(1L);
}
