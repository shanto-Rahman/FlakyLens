@Test public void handledExceptionIsRecordedInMetricTag() throws Exception {
assertThat(this.registry.get("http.server.requests").tags("exception","Exception1","status","500").timer().count()).isEqualTo(1L);
}