@Test void shouldHandleMultipleHealthStateViewsCorrectly() throws IOException {
  final HealthStateView fooView=new HealthStateView("foo",true,HealthCheckType.READY,true);
  final HealthStateView barView=new HealthStateView("bar",true,HealthCheckType.ALIVE,true);
  final HealthStateView bazView=new HealthStateView("baz",false,HealthCheckType.READY,false);
  final Collection<String> names=new ArrayList<>();
  names.add(fooView.getName());
  names.add(barView.getName());
  names.add(bazView.getName());
  final Map<String,Collection<String>> queryParams=Collections.singletonMap(JsonHealthResponseProvider.NAME_QUERY_PARAM,names);
  when(healthStateAggregator.healthStateView(fooView.getName())).thenReturn(Optional.of(fooView));
  when(healthStateAggregator.healthStateView(barView.getName())).thenReturn(Optional.of(barView));
  when(healthStateAggregator.healthStateView(bazView.getName())).thenReturn(Optional.of(bazView));
  when(healthStatusChecker.isHealthy(isNull())).thenReturn(true);
  final HealthResponse response=jsonHealthResponseProvider.healthResponse(queryParams);
  assertThat(response.isHealthy()).isTrue();
  assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
  assertThat(response.getMessage()).isEqualToIgnoringWhitespace(fixture("/json/multiple-healthy-responses.json"));
}
