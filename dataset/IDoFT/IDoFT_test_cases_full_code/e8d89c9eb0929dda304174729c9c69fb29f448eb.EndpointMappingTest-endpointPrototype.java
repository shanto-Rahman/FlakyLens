@Test public void endpointPrototype() throws Exception {
  StaticApplicationContext applicationContext=new StaticApplicationContext();
  applicationContext.registerPrototype("endpoint",MyEndpoint.class);
  AbstractEndpointMapping mapping=new AbstractEndpointMapping(){
    @Override protected Object getEndpointInternal(    MessageContext message) throws Exception {
      assertEquals("Invalid request",messageContext,message);
      return "endpoint";
    }
  }
;
  mapping.setApplicationContext(applicationContext);
  EndpointInvocationChain result=mapping.getEndpoint(messageContext);
  assertNotNull("No endpoint returned",result);
  result=mapping.getEndpoint(messageContext);
  assertNotNull("No endpoint returned",result);
  assertEquals("Prototype endpoint was not constructed twice",2,MyEndpoint.constructorCount);
}
