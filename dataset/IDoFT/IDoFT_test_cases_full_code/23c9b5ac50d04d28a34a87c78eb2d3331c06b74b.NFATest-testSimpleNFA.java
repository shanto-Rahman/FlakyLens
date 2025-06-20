@Test public void testSimpleNFA() throws Exception {
  List<StreamRecord<Event>> streamEvents=new ArrayList<>();
  streamEvents.add(new StreamRecord<>(new Event(1,"start",1.0),1L));
  streamEvents.add(new StreamRecord<>(new Event(2,"bar",2.0),2L));
  streamEvents.add(new StreamRecord<>(new Event(3,"start",3.0),3L));
  streamEvents.add(new StreamRecord<>(new Event(4,"end",4.0),4L));
  State<Event> startState=new State<>("start",State.StateType.Start);
  State<Event> endState=new State<>("end",State.StateType.Normal);
  State<Event> endingState=new State<>("",State.StateType.Final);
  startState.addTake(endState,new SimpleCondition<Event>(){
    private static final long serialVersionUID=-4869589195918650396L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("start");
    }
  }
);
  endState.addTake(endingState,new SimpleCondition<Event>(){
    private static final long serialVersionUID=2979804163709590673L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("end");
    }
  }
);
  endState.addIgnore(BooleanConditions.<Event>trueFunction());
  List<State<Event>> states=new ArrayList<>();
  states.add(startState);
  states.add(endState);
  states.add(endingState);
  List<Map<String,List<Event>>> expectedPatterns=new ArrayList<>();
  Map<String,List<Event>> firstPattern=new HashMap<>();
  firstPattern.put("start",Collections.singletonList(new Event(1,"start",1.0)));
  firstPattern.put("end",Collections.singletonList(new Event(4,"end",4.0)));
  Map<String,List<Event>> secondPattern=new HashMap<>();
  secondPattern.put("start",Collections.singletonList(new Event(3,"start",3.0)));
  secondPattern.put("end",Collections.singletonList(new Event(4,"end",4.0)));
  expectedPatterns.add(firstPattern);
  expectedPatterns.add(secondPattern);
  NFA<Event> nfa=new NFA<>(states,0,false);
  NFATestHarness nfaTestHarness=NFATestHarness.forNFA(nfa).build();
  Collection<Map<String,List<Event>>> actualPatterns=nfaTestHarness.consumeRecords(streamEvents);
  assertEquals(expectedPatterns,actualPatterns);
}
