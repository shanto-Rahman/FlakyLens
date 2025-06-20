@Test public void testNFASerialization() throws Exception {
  Pattern<Event,?> pattern1=Pattern.<Event>begin("start").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=1858562682635302605L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("a");
    }
  }
).followedByAny("middle").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=8061969839441121955L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("b");
    }
  }
).oneOrMore().optional().allowCombinations().followedByAny("end").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=8061969839441121955L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("d");
    }
  }
);
  Pattern<Event,?> pattern2=Pattern.<Event>begin("start").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=1858562682635302605L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("a");
    }
  }
).notFollowedBy("not").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=-6085237016591726715L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("c");
    }
  }
).followedByAny("middle").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=8061969839441121955L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("b");
    }
  }
).oneOrMore().optional().allowCombinations().followedByAny("end").where(new IterativeCondition<Event>(){
    private static final long serialVersionUID=8061969839441121955L;
    @Override public boolean filter(    Event value,    IterativeCondition.Context<Event> ctx) throws Exception {
      double sum=0.0;
      for (      Event e : ctx.getEventsForPattern("middle")) {
        sum+=e.getPrice();
      }
      return sum > 5.0;
    }
  }
);
  Pattern<Event,?> pattern3=Pattern.<Event>begin("start").notFollowedBy("not").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=-6085237016591726715L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("c");
    }
  }
).followedByAny("middle").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=8061969839441121955L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("b");
    }
  }
).oneOrMore().allowCombinations().followedByAny("end").where(new SimpleCondition<Event>(){
    private static final long serialVersionUID=8061969839441121955L;
    @Override public boolean filter(    Event value) throws Exception {
      return value.getName().equals("d");
    }
  }
);
  List<Pattern<Event,?>> patterns=new ArrayList<>();
  patterns.add(pattern1);
  patterns.add(pattern2);
  patterns.add(pattern3);
  for (  Pattern<Event,?> p : patterns) {
    NFA<Event> nfa=compile(p,false);
    Event a=new Event(40,"a",1.0);
    Event b=new Event(41,"b",2.0);
    Event c=new Event(42,"c",3.0);
    Event b1=new Event(41,"b",3.0);
    Event b2=new Event(41,"b",4.0);
    Event b3=new Event(41,"b",5.0);
    Event d=new Event(43,"d",4.0);
    NFAState nfaState=nfa.createInitialNFAState();
    NFATestHarness nfaTestHarness=NFATestHarness.forNFA(nfa).withNFAState(nfaState).build();
    nfaTestHarness.consumeRecord(new StreamRecord<>(a,1));
    nfaTestHarness.consumeRecord(new StreamRecord<>(b,2));
    nfaTestHarness.consumeRecord(new StreamRecord<>(c,3));
    nfaTestHarness.consumeRecord(new StreamRecord<>(b1,4));
    nfaTestHarness.consumeRecord(new StreamRecord<>(b2,5));
    nfaTestHarness.consumeRecord(new StreamRecord<>(b3,6));
    nfaTestHarness.consumeRecord(new StreamRecord<>(d,7));
    nfaTestHarness.consumeRecord(new StreamRecord<>(a,8));
    NFAStateSerializer serializer=new NFAStateSerializer();
    ByteArrayOutputStream baos=new ByteArrayOutputStream();
    serializer.serialize(nfaState,new DataOutputViewStreamWrapper(baos));
    baos.close();
    ByteArrayInputStream in=new ByteArrayInputStream(baos.toByteArray());
    ByteArrayOutputStream out=new ByteArrayOutputStream();
    serializer.duplicate().copy(new DataInputViewStreamWrapper(in),new DataOutputViewStreamWrapper(out));
    in.close();
    out.close();
    ByteArrayInputStream bais=new ByteArrayInputStream(out.toByteArray());
    NFAState copy=serializer.duplicate().deserialize(new DataInputViewStreamWrapper(bais));
    bais.close();
    assertEquals(nfaState,copy);
  }
}
