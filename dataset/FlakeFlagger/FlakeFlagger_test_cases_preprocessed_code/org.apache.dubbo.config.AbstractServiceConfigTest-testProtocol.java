@Test public void testProtocol() throws Exception {
assertThat(serviceConfig.getProtocol(),nullValue());
assertThat(serviceConfig.getProtocol(),notNullValue());
assertThat(serviceConfig.getProtocols(),hasSize(1));
}