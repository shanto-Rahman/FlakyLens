@Test public void timedControllerClass() throws Exception {
assertThat(this.registry.get("http.server.requests").tags("status","200").timer().count()).isEqualTo(1L);
}