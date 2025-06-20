@Test public void rethrownExceptionIsRecordedInMetricTag(){
  assertThatCode(() -> this.mvc.perform(get("/api/rethrownError")).andExpect(status().is5xxServerError()));
  assertThat(this.registry.get("http.server.requests").tags("exception","Exception2","status","500").timer().count()).isEqualTo(1L);
}
