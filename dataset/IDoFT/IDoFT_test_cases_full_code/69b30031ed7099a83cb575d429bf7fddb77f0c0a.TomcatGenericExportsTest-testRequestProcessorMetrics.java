@Test public void testRequestProcessorMetrics() throws Exception {
  assertThat(CollectorRegistry.defaultRegistry.getSampleValue("tomcat_requestprocessor_received_bytes",new String[]{"name"},new String[]{"http-nio-auto-1"}),is(notNullValue()));
  assertThat(CollectorRegistry.defaultRegistry.getSampleValue("tomcat_requestprocessor_sent_bytes",new String[]{"name"},new String[]{"http-nio-auto-1"}),is(greaterThan(0.0)));
  assertThat(CollectorRegistry.defaultRegistry.getSampleValue("tomcat_requestprocessor_time_seconds",new String[]{"name"},new String[]{"http-nio-auto-1"}),is(greaterThan(0.0)));
  assertThat(CollectorRegistry.defaultRegistry.getSampleValue("tomcat_requestprocessor_error_count",new String[]{"name"},new String[]{"http-nio-auto-1"}),is(0.0));
  assertThat(CollectorRegistry.defaultRegistry.getSampleValue("tomcat_requestprocessor_request_count",new String[]{"name"},new String[]{"http-nio-auto-1"}),is(1.0));
}
