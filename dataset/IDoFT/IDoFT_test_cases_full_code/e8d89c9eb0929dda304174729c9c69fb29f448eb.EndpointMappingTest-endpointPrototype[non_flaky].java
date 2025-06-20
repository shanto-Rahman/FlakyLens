@Test public void endpointPrototype() throws Exception {
  StaticApplicationContext applicationContext=new StaticApplicationContext();
  applicationContext.registerPrototype("endpoint",MyEndpoint.class);
  AbstractEndpointMapping mapping=new AbstractEndpointMapping(){
    @Override protected Object getEndpointInternal(    MessageContext message) throws Exception {
      assertThat(message).isEqualTo(messageContext);
      return "endpoint";
    }
  }
;
  mapping.setApplicationContext(applicationContext);
  EndpointInvocationChain result=mapping.getEndpoint(messageContext);
  assertThat(result).isNotNull();
  result=mapping.getEndpoint(messageContext);
  assertThat(result).isNotNull();
  assertThat(MyEndpoint.constructorCount).isEqualTo(2);
  MyEndpoint.reset();
}
