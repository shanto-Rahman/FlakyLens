@Test public void testSlotSharingOnAllVerticesInSameSlotSharingGroupByDefaultEnabled(){
  final StreamGraph streamGraph=createStreamGraphForSlotSharingTest();
  streamGraph.getStreamNodes().stream().filter(n -> "map1".equals(n.getOperatorName())).findFirst().get().setSlotSharingGroup("testSlotSharingGroup");
  streamGraph.setAllVerticesInSameSlotSharingGroupByDefault(true);
  final JobGraph jobGraph=StreamingJobGraphGenerator.createJobGraph(streamGraph);
  final List<JobVertex> verticesSorted=jobGraph.getVerticesSortedTopologicallyFromSources();
  assertEquals(4,verticesSorted.size());
  final List<JobVertex> verticesMatched=getExpectedVerticesList(verticesSorted);
  final JobVertex source1Vertex=verticesMatched.get(0);
  final JobVertex source2Vertex=verticesMatched.get(1);
  final JobVertex map1Vertex=verticesMatched.get(2);
  final JobVertex map2Vertex=verticesMatched.get(3);
  assertSameSlotSharingGroup(source1Vertex,source2Vertex,map2Vertex);
  assertDistinctSharingGroups(source1Vertex,map1Vertex);
}
