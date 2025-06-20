@Test @InSequence(3) public void testManagementDescriptionMetrics() throws Exception {
assertThat(endpoints.size() > 0,is(true));
assertThat(wsdl,is(notNullValue()));
assertThat(endpoint.hasDefined("request-count"),is(true));
assertThat(endpoint.get("request-count").asString(),is("1"));
}