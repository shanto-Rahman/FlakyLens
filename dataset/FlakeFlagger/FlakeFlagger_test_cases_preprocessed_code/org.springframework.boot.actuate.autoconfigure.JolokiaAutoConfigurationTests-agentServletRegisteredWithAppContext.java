@Test public void agentServletRegisteredWithAppContext() throws Exception {
assertEquals(1,this.context.getBeanNamesForType(JolokiaMvcEndpoint.class).length);
}