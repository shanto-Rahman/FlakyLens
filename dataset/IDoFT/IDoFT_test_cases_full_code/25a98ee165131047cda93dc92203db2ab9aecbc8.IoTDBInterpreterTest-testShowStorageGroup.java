@Test public void testShowStorageGroup(){
  InterpreterResult actual=interpreter.internalInterpret("SHOW STORAGE GROUP",null);
  String gt="storage group\n" + "root.test.wf02\n" + "root.test.wf01";
  Assert.assertNotNull(actual);
  Assert.assertEquals(Code.SUCCESS,actual.code());
  Assert.assertEquals(gt,actual.message().get(0).getData());
}
