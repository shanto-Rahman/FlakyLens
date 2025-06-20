@Test public void agentDisabled() throws Exception {
assertEquals(0,this.context.getBeanNamesForType(JolokiaMvcEndpoint.class).length);
}