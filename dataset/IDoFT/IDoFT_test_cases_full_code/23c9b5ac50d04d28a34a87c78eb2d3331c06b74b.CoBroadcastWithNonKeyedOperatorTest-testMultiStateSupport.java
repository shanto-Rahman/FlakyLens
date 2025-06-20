@Test public void testMultiStateSupport() throws Exception {
  try (TwoInputStreamOperatorTestHarness<String,Integer,String> testHarness=getInitializedTestHarness(new FunctionWithMultipleStates(),STATE_DESCRIPTOR,STATE_DESCRIPTOR_A)){
    testHarness.processElement2(new StreamRecord<>(5,12L));
    testHarness.processElement2(new StreamRecord<>(6,13L));
    testHarness.processElement1(new StreamRecord<>("9",15L));
    Queue<Object> expectedBr=new ConcurrentLinkedQueue<>();
    expectedBr.add(new StreamRecord<>("9:key.6->6",15L));
    expectedBr.add(new StreamRecord<>("9:key.5->5",15L));
    expectedBr.add(new StreamRecord<>("9:5->value.5",15L));
    expectedBr.add(new StreamRecord<>("9:6->value.6",15L));
    TestHarnessUtil.assertOutputEquals("Wrong Side Output",expectedBr,testHarness.getOutput());
  }
 }
