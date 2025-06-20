@Test public void subclassedTimedMethod() throws Exception {
assertThat(this.registry.get("http.server.requests").tags("status","200","uri","/api/c1/metaTimed/{id}").timer().count()).isEqualTo(1L);
}