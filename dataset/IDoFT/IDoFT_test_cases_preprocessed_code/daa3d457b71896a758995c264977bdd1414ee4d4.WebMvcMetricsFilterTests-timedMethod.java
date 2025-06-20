@Test public void timedMethod() throws Exception {
assertThat(this.registry.get("http.server.requests").tags("status","200","uri","/api/c1/{id}","public","true").timer().count()).isEqualTo(1);
}