@Test public void testRequestTopicResponseStaticQueue() throws Exception {
  EndpointInfo ei=setupServiceInfo("http://cxf.apache.org/jms_simple","/wsdl/jms_spec_testsuite.wsdl","JMSSimpleService002X","SimplePortTopicRequestQueueResponse");
  sendAndReceiveMessages(ei,true);
  sendAndReceiveMessages(ei,false);
}
