/** 
 * a.proctime >= b.proctime - 10 and a.proctime <= b.proctime + 20. 
 */
@Test public void testProcTimeInnerJoinWithCommonBounds() throws Exception {
  ProcTimeBoundedStreamJoin joinProcessFunc=new ProcTimeBoundedStreamJoin(FlinkJoinType.INNER,-10,20,rowType,rowType,generatedFunction);
  KeyedTwoInputStreamOperatorTestHarness<BaseRow,BaseRow,BaseRow,BaseRow> testHarness=createTestHarness(joinProcessFunc);
  testHarness.open();
  testHarness.setProcessingTime(1);
  testHarness.processElement1(record(1L,"1a1"));
  assertEquals(1,testHarness.numProcessingTimeTimers());
  testHarness.setProcessingTime(2);
  testHarness.processElement1(record(2L,"2a2"));
  assertEquals(2,testHarness.numProcessingTimeTimers());
  testHarness.setProcessingTime(3);
  testHarness.processElement1(record(1L,"1a3"));
  assertEquals(4,testHarness.numKeyedStateEntries());
  assertEquals(2,testHarness.numProcessingTimeTimers());
  testHarness.processElement2(record(1L,"1b3"));
  testHarness.setProcessingTime(4);
  testHarness.processElement2(record(2L,"2b4"));
  assertEquals(8,testHarness.numKeyedStateEntries());
  assertEquals(4,testHarness.numProcessingTimeTimers());
  testHarness.setProcessingTime(13);
  testHarness.processElement2(record(1L,"1b13"));
  testHarness.setProcessingTime(33);
  assertEquals(4,testHarness.numKeyedStateEntries());
  assertEquals(2,testHarness.numProcessingTimeTimers());
  testHarness.processElement1(record(1L,"1a33"));
  testHarness.processElement1(record(2L,"2a33"));
  testHarness.processElement2(record(2L,"2b33"));
  List<Object> expectedOutput=new ArrayList<>();
  expectedOutput.add(record(1L,"1a1",1L,"1b3"));
  expectedOutput.add(record(1L,"1a3",1L,"1b3"));
  expectedOutput.add(record(2L,"2a2",2L,"2b4"));
  expectedOutput.add(record(1L,"1a3",1L,"1b13"));
  expectedOutput.add(record(1L,"1a33",1L,"1b13"));
  expectedOutput.add(record(2L,"2a33",2L,"2b33"));
  assertor.assertOutputEquals("output wrong.",expectedOutput,testHarness.getOutput());
  testHarness.close();
}
