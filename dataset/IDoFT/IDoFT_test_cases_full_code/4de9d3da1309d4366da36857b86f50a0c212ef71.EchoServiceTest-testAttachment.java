@Test public void testAttachment(){
  TraceContext.setTrace(Trace.newParentTrace());
  EchoInfo echoInfo=getEchoInfo();
  EchoServiceImpl ecohImpl=new EchoServiceImpl();
  EchoInfo response=echoService.echoWithAttachement(echoInfo);
  Assert.assertEquals(ecohImpl.doEcho(echoInfo).getMessage(),response.getMessage());
}
