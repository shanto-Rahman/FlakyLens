@Test public void testCoOperation(){
  StreamExecutionEnvironment env=StreamExecutionEnvironment.getExecutionEnvironment();
  CoMapFunction<Long,Long,Long> dummyCoMap=new CoMapFunction<Long,Long,Long>(){
    @Override public Long map1(    Long value) throws Exception {
      return null;
    }
    @Override public Long map2(    Long value) throws Exception {
      return null;
    }
  }
;
  DataStream<Long> src1=env.generateSequence(1,10);
  DataStream<Long> src2=env.generateSequence(1,10).slotSharingGroup("src-1");
  src1.connect(src2).map(dummyCoMap);
  DataStream<Long> src3=env.generateSequence(1,10).slotSharingGroup("group-1");
  DataStream<Long> src4=env.generateSequence(1,10).slotSharingGroup("group-1");
  src3.connect(src4).map(dummyCoMap);
  JobGraph jobGraph=env.getStreamGraph().getJobGraph();
  List<JobVertex> vertices=jobGraph.getVerticesSortedTopologicallyFromSources();
  assertEquals(vertices.get(0).getSlotSharingGroup(),vertices.get(4).getSlotSharingGroup());
  assertNotEquals(vertices.get(0).getSlotSharingGroup(),vertices.get(1).getSlotSharingGroup());
  assertNotEquals(vertices.get(1).getSlotSharingGroup(),vertices.get(4).getSlotSharingGroup());
  assertEquals(vertices.get(2).getSlotSharingGroup(),vertices.get(3).getSlotSharingGroup());
  assertEquals(vertices.get(2).getSlotSharingGroup(),vertices.get(5).getSlotSharingGroup());
  assertEquals(vertices.get(3).getSlotSharingGroup(),vertices.get(5).getSlotSharingGroup());
}
