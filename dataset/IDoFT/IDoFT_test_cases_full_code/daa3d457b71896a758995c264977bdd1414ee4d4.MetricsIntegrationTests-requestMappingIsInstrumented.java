@Test public void requestMappingIsInstrumented(){
  this.loopback.getForObject("/api/people",Set.class);
  assertThat(this.registry.get("http.server.requests").timer().count()).isEqualTo(1);
}
