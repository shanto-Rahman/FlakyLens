@Test public void testDynamiceTalkTimeout(){
  EchoInfo echoInfo=getEchoInfo();
  TalkTimeoutController.setTalkTimeout(1);
  try {
    echoService.echo(echoInfo);
    Assert.fail("Shold throw time out exception here");
  }
 catch (  Exception e) {
    Assert.assertNotNull(e);
    e.printStackTrace();
  }
}
