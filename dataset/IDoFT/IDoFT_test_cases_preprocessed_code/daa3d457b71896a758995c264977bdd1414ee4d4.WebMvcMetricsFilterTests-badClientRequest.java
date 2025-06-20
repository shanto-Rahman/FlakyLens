@Test public void badClientRequest() throws Exception {
assertThat(this.registry.get("http.server.requests").tags("status","400").timer().count()).isEqualTo(1L);
}