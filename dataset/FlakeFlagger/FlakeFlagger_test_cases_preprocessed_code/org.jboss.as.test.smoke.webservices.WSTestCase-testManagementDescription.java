@Test @InSequence(2) public void testManagementDescription() throws Exception {
assertThat(endpoints.size() > 0,is(true));
assertThat(endpoint.hasDefined("class"),is(true));
assertThat(endpoint.hasDefined("name"),is(true));
assertThat(endpoint.hasDefined("wsdl-url"),is(true));
assertThat(endpoint.get("wsdl-url").asString().endsWith("?wsdl"),is(true));
assertThat(endpoint.hasDefined("request-count"),is(true));
assertThat(endpoint.get("request-count").asString(),is("0"));
}