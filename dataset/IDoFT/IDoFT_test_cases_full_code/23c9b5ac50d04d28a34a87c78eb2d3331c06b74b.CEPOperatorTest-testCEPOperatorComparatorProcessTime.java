@Test public void testCEPOperatorComparatorProcessTime() throws Exception {
  Event startEvent1=new Event(42,"start",1.0);
  Event startEvent2=new Event(42,"start",2.0);
  SubEvent middleEvent1=new SubEvent(42,"foo1",3.0,10.0);
  SubEvent middleEvent2=new SubEvent(42,"foo2",4.0,10.0);
  Event endEvent1=new Event(42,"end",1.0);
  Event startEventK2=new Event(43,"start",1.0);
  CepOperator<Event,Integer,Map<String,List<Event>>> operator=getKeyedCepOperatorWithComparator(true);
  OneInputStreamOperatorTestHarness<Event,Map<String,List<Event>>> harness=CepOperatorTestUtilities.getCepTestHarness(operator);
  try {
    harness.open();
    harness.setProcessingTime(0L);
    harness.processElement(new StreamRecord<>(startEvent1,0L));
    harness.processElement(new StreamRecord<>(startEventK2,0L));
    harness.processElement(new StreamRecord<>(new Event(42,"foobar",1.0),0L));
    harness.processElement(new StreamRecord<>(new SubEvent(42,"barfoo",1.0,5.0),0L));
    assertTrue(!operator.hasNonEmptySharedBuffer(42));
    assertTrue(!operator.hasNonEmptySharedBuffer(43));
    harness.setProcessingTime(3L);
    assertTrue(operator.hasNonEmptySharedBuffer(42));
    assertTrue(operator.hasNonEmptySharedBuffer(43));
    harness.processElement(new StreamRecord<>(middleEvent2,3L));
    harness.processElement(new StreamRecord<>(middleEvent1,3L));
    harness.processElement(new StreamRecord<>(startEvent2,3L));
    OperatorSubtaskState snapshot=harness.snapshot(0L,0L);
    harness.close();
    CepOperator<Event,Integer,Map<String,List<Event>>> operator2=getKeyedCepOperatorWithComparator(true);
    harness=CepOperatorTestUtilities.getCepTestHarness(operator2);
    harness.setup();
    harness.initializeState(snapshot);
    harness.open();
    harness.setProcessingTime(4L);
    harness.processElement(new StreamRecord<>(endEvent1,5L));
    harness.setProcessingTime(5L);
    verifyPattern(harness.getOutput().poll(),startEvent1,middleEvent1,endEvent1);
    verifyPattern(harness.getOutput().poll(),startEvent1,middleEvent2,endEvent1);
    verifyPattern(harness.getOutput().poll(),startEvent2,middleEvent1,endEvent1);
    verifyPattern(harness.getOutput().poll(),startEvent2,middleEvent2,endEvent1);
  }
  finally {
    harness.close();
  }
}
