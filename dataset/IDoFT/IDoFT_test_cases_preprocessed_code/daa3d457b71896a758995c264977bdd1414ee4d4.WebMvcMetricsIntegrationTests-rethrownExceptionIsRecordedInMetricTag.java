@Test public void rethrownExceptionIsRecordedInMetricTag(){
assertThat(this.registry.get("http.server.requests").tags("exception","Exception2","status","500").timer().count()).isEqualTo(1L);
}