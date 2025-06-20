@Test public void testShowAllTTL(){
  interpreter.internalInterpret("SET TTL TO root.test.wf01 12345",null);
  InterpreterResult actual=interpreter.internalInterpret("SHOW ALL TTL",null);
  String gt="storage group\tttl\n" + "root.test.wf02\tnull\n" + "root.test.wf01\t12345";
  Assert.assertNotNull(actual);
  Assert.assertEquals(Code.SUCCESS,actual.code());
  Assert.assertEquals(gt,actual.message().get(0).getData());
}
