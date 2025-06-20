@Test public void testExtractLogs(){
  SampleResult result=createDummySampleResult("foo");
  this.client.handleSampleResults(Collections.singletonList(result),context);
  Assert.assertEquals(1,this.logsBuffer.size());
  String expectedPayload="{\"sample_start_time\":1.0,\"response_code\":\"123\",\"headers_size\":0.0,\"sample_label\":\"foo\",\"latency\":12.0,\"group_threads\":0.0,\"idle_time\":0.0,\"error_count\":0.0,\"message\":\"\",\"url\":\"\",\"ddsource\":\"jmeter\",\"sent_bytes\":124.0,\"thread_group\":\"bar\",\"body_size\":0.0,\"content_type\":\"\",\"load_time\":125.0,\"thread_name\":\"bar baz\",\"sample_end_time\":126.0,\"bytes\":12345.0,\"connect_time\":0.0,\"sample_count\":10.0,\"data_type\":\"\",\"all_threads\":0.0,\"data_encoding\":null}";
  Assert.assertEquals(this.logsBuffer.get(0).toString(),expectedPayload);
}
