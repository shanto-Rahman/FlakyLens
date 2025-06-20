@Test public void regexBasedRequestMapping() throws Exception {
assertThat(this.registry.get("http.server.requests").tags("uri","/api/c1/regex/{id:\\.[a-z]+}").timer().count()).isEqualTo(1L);
}