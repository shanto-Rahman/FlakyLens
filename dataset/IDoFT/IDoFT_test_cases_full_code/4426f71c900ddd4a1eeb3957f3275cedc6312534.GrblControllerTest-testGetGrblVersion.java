@Test public void testGetGrblVersion() throws Exception {
  System.out.println("getGrblVersion");
  GrblController instance=new GrblController(mgc);
  String result;
  String expResult;
  expResult="<Not connected>";
  result=instance.getGrblVersion();
  assertEquals(expResult,result);
  instance.openCommPort(getSettings().getConnectionDriver(),"blah",1234);
  expResult="Grbl 0.5b";
  instance.rawResponseHandler(expResult);
  result=instance.getGrblVersion();
  assertEquals(expResult,result);
  expResult="Grbl 0.57";
  instance.rawResponseHandler(expResult);
  result=instance.getGrblVersion();
  assertEquals(expResult,result);
  expResult="Grbl 0.8";
  instance.rawResponseHandler(expResult);
  result=instance.getGrblVersion();
  assertEquals(expResult,result);
  expResult="Grbl 0.8c";
  instance.rawResponseHandler(expResult);
  result=instance.getGrblVersion();
  assertEquals(expResult,result);
}
