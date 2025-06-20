/** 
 * a.rowtime >= b.rowtime - 10 and a.rowtime <= b.rowtime + 20. 
 */
@Test public void testRowTimeInnerJoinWithCommonBounds() throws Exception {
  RowTimeBoundedStreamJoin joinProcessFunc=new RowTimeBoundedStreamJoin(FlinkJoinType.INNER,-10,20,0,rowType,rowType,generatedFunction,0,0);
  KeyedTwoInputStreamOperatorTestHarness<BaseRow,BaseRow,BaseRow,BaseRow> testHarness=createTestHarness(joinProcessFunc);
  testHarness.open();
  testHarness.processWatermark1(new Watermark(1));
  testHarness.processWatermark2(new Watermark(1));
  testHarness.processElement1(record(1L,"k1"));
  assertEquals(1,testHarness.numEventTimeTimers());
  testHarness.processElement1(record(2L,"k1"));
  testHarness.processElement2(record(2L,"k1"));
  assertEquals(2,testHarness.numEventTimeTimers());
  assertEquals(4,testHarness.numKeyedStateEntries());
  testHarness.processElement1(record(5L,"k1"));
  testHarness.processElement2(record(15L,"k1"));
  testHarness.processWatermark1(new Watermark(20));
  testHarness.processWatermark2(new Watermark(20));
  assertEquals(4,testHarness.numKeyedStateEntries());
  testHarness.processElement1(record(35L,"k1"));
  testHarness.processWatermark1(new Watermark(38));
  testHarness.processWatermark2(new Watermark(38));
  testHarness.processElement1(record(40L,"k2"));
  testHarness.processElement2(record(39L,"k2"));
  assertEquals(6,testHarness.numKeyedStateEntries());
  testHarness.processWatermark1(new Watermark(61));
  testHarness.processWatermark2(new Watermark(61));
  assertEquals(4,testHarness.numKeyedStateEntries());
  List<Object> expectedOutput=new ArrayList<>();
  expectedOutput.add(new Watermark(-19));
  expectedOutput.add(record(1L,"k1",2L,"k1"));
  expectedOutput.add(record(2L,"k1",2L,"k1"));
  expectedOutput.add(record(5L,"k1",2L,"k1"));
  expectedOutput.add(record(5L,"k1",15L,"k1"));
  expectedOutput.add(new Watermark(0));
  expectedOutput.add(record(35L,"k1",15L,"k1"));
  expectedOutput.add(new Watermark(18));
  expectedOutput.add(record(40L,"k2",39L,"k2"));
  expectedOutput.add(new Watermark(41));
  assertor.assertOutputEquals("output wrong.",expectedOutput,testHarness.getOutput());
  testHarness.close();
}
