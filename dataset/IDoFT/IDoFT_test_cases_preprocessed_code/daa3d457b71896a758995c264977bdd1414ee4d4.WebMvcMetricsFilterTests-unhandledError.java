@Test public void unhandledError(){
assertThat(this.registry.get("http.server.requests").tags("exception","RuntimeException").timer().count()).isEqualTo(1L);
}