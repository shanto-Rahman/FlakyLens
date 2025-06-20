@Test public void testUnion(){
  StreamExecutionEnvironment env=StreamExecutionEnvironment.getExecutionEnvironment();
  FilterFunction<Long> dummyFilter=new FilterFunction<Long>(){
    @Override public boolean filter(    Long value){
      return false;
    }
  }
;
  DataStream<Long> src1=env.generateSequence(1,10);
  DataStream<Long> src2=env.generateSequence(1,10).slotSharingGroup("src-1");
  src1.union(src2).filter(dummyFilter);
  DataStream<Long> src3=env.generateSequence(1,10).slotSharingGroup("group-1");
  DataStream<Long> src4=env.generateSequence(1,10).slotSharingGroup("group-1");
  src3.union(src4).filter(dummyFilter);
  JobGraph jobGraph=env.getStreamGraph().getJobGraph();
  List<JobVertex> vertices=jobGraph.getVerticesSortedTopologicallyFromSources();
  assertEquals(vertices.get(0).getSlotSharingGroup(),vertices.get(4).getSlotSharingGroup());
  assertNotEquals(vertices.get(0).getSlotSharingGroup(),vertices.get(1).getSlotSharingGroup());
  assertNotEquals(vertices.get(1).getSlotSharingGroup(),vertices.get(4).getSlotSharingGroup());
  assertEquals(vertices.get(2).getSlotSharingGroup(),vertices.get(3).getSlotSharingGroup());
  assertEquals(vertices.get(2).getSlotSharingGroup(),vertices.get(5).getSlotSharingGroup());
  assertEquals(vertices.get(3).getSlotSharingGroup(),vertices.get(5).getSlotSharingGroup());
}
