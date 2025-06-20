/** 
 * Test of isReadyToStreamFile method, of class GrblController.
 */
@Test public void testIsReadyToStreamFile() throws Exception {
  System.out.println("isReadyToStreamFile");
  GrblController instance=new GrblController(mgc);
  boolean asserted;
  try {
    asserted=false;
    instance.openCommPort(getSettings().getConnectionDriver(),"blah",1234);
    instance.isReadyToStreamFile();
  }
 catch (  Exception e) {
    asserted=true;
    assertEquals("Grbl has not finished booting.",e.getMessage());
  }
  assertTrue(asserted);
  instance.closeCommPort();
  instance.openCommPort(getSettings().getConnectionDriver(),"blah",1234);
  instance.rawResponseHandler("Grbl 0.8c");
  Boolean result=instance.isReadyToStreamFile();
  assertEquals(true,result);
  instance.queueStream(new SimpleGcodeStreamReader(instance.createCommand("G0X0")));
  try {
    mgc.areActiveCommands=true;
    asserted=false;
    instance.isReadyToStreamFile();
  }
 catch (  Exception e) {
    asserted=true;
    assertEquals("Cannot stream while there are active commands: ",e.getMessage());
  }
  assertTrue(asserted);
}
