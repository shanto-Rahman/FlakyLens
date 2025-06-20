@Test public void testCEPOperatorCleanupProcessingTime() throws Exception {
  Event startEvent1=new Event(42,"start",1.0);
  Event startEvent2=new Event(42,"start",2.0);
  SubEvent middleEvent1=new SubEvent(42,"foo1",1.0,10.0);
  SubEvent middleEvent2=new SubEvent(42,"foo2",1.0,10.0);
  SubEvent middleEvent3=new SubEvent(42,"foo3",1.0,10.0);
  Event endEvent1=new Event(42,"end",1.0);
  Event endEvent2=new Event(42,"end",2.0);
  Event startEventK2=new Event(43,"start",1.0);
  CepOperator<Event,Integer,Map<String,List<Event>>> operator=getKeyedCepOperator(true);
  OneInputStreamOperatorTestHarness<Event,Map<String,List<Event>>> harness=CepOperatorTestUtilities.getCepTestHarness(operator);
  try {
    harness.open();
    harness.setProcessingTime(0L);
    harness.processElement(new StreamRecord<>(startEvent1,1L));
    harness.processElement(new StreamRecord<>(startEventK2,1L));
    harness.processElement(new StreamRecord<>(new Event(42,"foobar",1.0),2L));
    harness.processElement(new StreamRecord<Event>(middleEvent1,2L));
    harness.processElement(new StreamRecord<Event>(new SubEvent(42,"barfoo",1.0,5.0),3L));
    assertTrue(!operator.hasNonEmptyPQ(42));
    assertTrue(!operator.hasNonEmptyPQ(43));
    assertTrue(operator.hasNonEmptySharedBuffer(42));
    assertTrue(operator.hasNonEmptySharedBuffer(43));
    harness.setProcessingTime(3L);
    harness.processElement(new StreamRecord<>(startEvent2,3L));
    harness.processElement(new StreamRecord<Event>(middleEvent2,4L));
    OperatorSubtaskState snapshot=harness.snapshot(0L,0L);
    harness.close();
    CepOperator<Event,Integer,Map<String,List<Event>>> operator2=getKeyedCepOperator(true);
    harness=CepOperatorTestUtilities.getCepTestHarness(operator2);
    harness.setup();
    harness.initializeState(snapshot);
    harness.open();
    harness.setProcessingTime(3L);
    harness.processElement(new StreamRecord<>(endEvent1,5L));
    verifyPattern(harness.getOutput().poll(),startEvent1,middleEvent1,endEvent1);
    verifyPattern(harness.getOutput().poll(),startEvent1,middleEvent2,endEvent1);
    verifyPattern(harness.getOutput().poll(),startEvent2,middleEvent2,endEvent1);
    harness.setProcessingTime(11L);
    harness.processElement(new StreamRecord<Event>(middleEvent3,11L));
    harness.processElement(new StreamRecord<>(endEvent2,12L));
    verifyPattern(harness.getOutput().poll(),startEvent2,middleEvent2,endEvent2);
    verifyPattern(harness.getOutput().poll(),startEvent2,middleEvent3,endEvent2);
    harness.setProcessingTime(21L);
    assertTrue(operator2.hasNonEmptySharedBuffer(42));
    harness.processElement(new StreamRecord<>(startEvent1,21L));
    assertTrue(operator2.hasNonEmptySharedBuffer(42));
    harness.setProcessingTime(49L);
    harness.processElement(new StreamRecord<>(new Event(42,"foobar",1.0),2L));
    assertTrue(!operator2.hasNonEmptySharedBuffer(42));
    assertEquals(0L,harness.numEventTimeTimers());
    assertTrue(!operator2.hasNonEmptyPQ(42));
    assertTrue(!operator2.hasNonEmptyPQ(43));
  }
  finally {
    harness.close();
  }
}
