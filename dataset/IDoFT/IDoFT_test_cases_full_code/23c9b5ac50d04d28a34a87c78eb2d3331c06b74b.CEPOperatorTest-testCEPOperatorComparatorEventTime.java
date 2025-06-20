@Test public void testCEPOperatorComparatorEventTime() throws Exception {
  Event startEvent1=new Event(42,"start",1.0);
  Event startEvent2=new Event(42,"start",2.0);
  SubEvent middleEvent1=new SubEvent(42,"foo1",1.0,10.0);
  SubEvent middleEvent2=new SubEvent(42,"foo2",2.0,10.0);
  Event endEvent=new Event(42,"end",1.0);
  Event startEventK2=new Event(43,"start",1.0);
  CepOperator<Event,Integer,Map<String,List<Event>>> operator=getKeyedCepOperatorWithComparator(false);
  OneInputStreamOperatorTestHarness<Event,Map<String,List<Event>>> harness=CepOperatorTestUtilities.getCepTestHarness(operator);
  try {
    harness.open();
    harness.processWatermark(0L);
    harness.processElement(new StreamRecord<>(startEvent1,1L));
    harness.processElement(new StreamRecord<>(startEventK2,1L));
    harness.processElement(new StreamRecord<>(new Event(42,"foobar",1.0),2L));
    harness.processElement(new StreamRecord<Event>(new SubEvent(42,"barfoo",1.0,5.0),3L));
    assertTrue(operator.hasNonEmptyPQ(42));
    assertTrue(operator.hasNonEmptyPQ(43));
    assertFalse(operator.hasNonEmptySharedBuffer(42));
    assertFalse(operator.hasNonEmptySharedBuffer(43));
    harness.processWatermark(3L);
    assertFalse(operator.hasNonEmptyPQ(42));
    assertFalse(operator.hasNonEmptyPQ(43));
    assertTrue(operator.hasNonEmptySharedBuffer(42));
    assertTrue(operator.hasNonEmptySharedBuffer(43));
    harness.processElement(new StreamRecord<>(startEvent2,4L));
    harness.processElement(new StreamRecord<Event>(middleEvent2,5L));
    harness.processElement(new StreamRecord<Event>(middleEvent1,5L));
    OperatorSubtaskState snapshot=harness.snapshot(0L,0L);
    harness.close();
    CepOperator<Event,Integer,Map<String,List<Event>>> operator2=getKeyedCepOperatorWithComparator(false);
    harness=CepOperatorTestUtilities.getCepTestHarness(operator2);
    harness.setup();
    harness.initializeState(snapshot);
    harness.open();
    harness.processElement(new StreamRecord<>(endEvent,6L));
    harness.processWatermark(6L);
    verifyPattern(harness.getOutput().poll(),startEvent1,middleEvent1,endEvent);
    verifyPattern(harness.getOutput().poll(),startEvent1,middleEvent2,endEvent);
    verifyPattern(harness.getOutput().poll(),startEvent2,middleEvent1,endEvent);
    verifyPattern(harness.getOutput().poll(),startEvent2,middleEvent2,endEvent);
    verifyWatermark(harness.getOutput().poll(),6L);
  }
  finally {
    harness.close();
  }
}
