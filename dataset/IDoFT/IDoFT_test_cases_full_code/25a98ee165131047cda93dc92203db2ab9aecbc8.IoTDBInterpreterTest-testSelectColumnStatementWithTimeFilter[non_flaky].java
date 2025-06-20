@Test public void testSelectColumnStatementWithTimeFilter(){
  InterpreterResult actual=interpreter.internalInterpret("select temperature, status, hardware from root.test.wf01.wt01 where time > 2 and time < 6",null);
  String gt="Time\troot.test.wf01.wt01.temperature\troot.test.wf01.wt01.status\troot.test.wf01.wt01.hardware\n" + "3\t3.3\tfalse\t33.0\n" + "4\t4.4\tfalse\t44.0\n"+ "5\t5.5\tfalse\t55.0";
  Assert.assertNotNull(actual);
  Assert.assertEquals(Code.SUCCESS,actual.code());
  Assert.assertEquals(gt,actual.message().get(0).getData());
}
