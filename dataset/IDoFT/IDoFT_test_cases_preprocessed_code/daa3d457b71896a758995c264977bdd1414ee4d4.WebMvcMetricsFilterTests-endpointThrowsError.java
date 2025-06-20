@Test public void endpointThrowsError() throws Exception {
assertThat(this.registry.get("http.server.requests").tags("status","422").timer().count()).isEqualTo(1L);
}