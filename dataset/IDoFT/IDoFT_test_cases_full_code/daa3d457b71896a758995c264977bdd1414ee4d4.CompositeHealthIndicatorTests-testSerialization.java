@Test public void testSerialization() throws Exception {
  Map<String,HealthIndicator> indicators=new HashMap<>();
  indicators.put("db1",this.one);
  indicators.put("db2",this.two);
  CompositeHealthIndicator innerComposite=new CompositeHealthIndicator(this.healthAggregator,indicators);
  CompositeHealthIndicator composite=new CompositeHealthIndicator(this.healthAggregator,Collections.singletonMap("db",innerComposite));
  Health result=composite.health();
  ObjectMapper mapper=new ObjectMapper();
  assertThat(mapper.writeValueAsString(result)).isEqualTo("{\"status\":\"UNKNOWN\",\"details\":{\"db\":{\"status\":\"UNKNOWN\"" + ",\"details\":{\"db1\":{\"status\":\"UNKNOWN\",\"details\"" + ":{\"1\":\"1\"}},\"db2\":{\"status\":\"UNKNOWN\",\"details\""+ ":{\"2\":\"2\"}}}}}}");
}
