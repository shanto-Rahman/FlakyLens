@Test public void requestMappingIsInstrumented(){
assertThat(this.registry.get("http.server.requests").timer().count()).isEqualTo(1);
}