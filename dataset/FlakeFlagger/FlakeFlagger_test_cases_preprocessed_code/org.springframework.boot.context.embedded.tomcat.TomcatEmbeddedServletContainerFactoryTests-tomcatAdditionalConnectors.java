@Test public void tomcatAdditionalConnectors() throws Exception {
assertThat(connectors.values().iterator().next().length,equalTo(listeners.length + 1));
}