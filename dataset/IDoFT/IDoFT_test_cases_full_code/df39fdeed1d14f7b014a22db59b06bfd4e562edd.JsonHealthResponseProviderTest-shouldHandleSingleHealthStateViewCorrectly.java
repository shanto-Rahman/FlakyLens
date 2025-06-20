@Test void shouldHandleSingleHealthStateViewCorrectly() throws IOException {
  final HealthStateView view=new HealthStateView("foo",true,HealthCheckType.READY,true);
  final Map<String,Collection<String>> queryParams=Collections.singletonMap(JsonHealthResponseProvider.NAME_QUERY_PARAM,Collections.singleton(view.getName()));
  when(healthStateAggregator.healthStateView(view.getName())).thenReturn(Optional.of(view));
  when(healthStatusChecker.isHealthy(isNull())).thenReturn(true);
  final HealthResponse response=jsonHealthResponseProvider.healthResponse(queryParams);
  assertThat(response.isHealthy()).isTrue();
  assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
  assertThat(response.getMessage()).isEqualToIgnoringWhitespace(fixture("/json/single-healthy-response.json"));
}
