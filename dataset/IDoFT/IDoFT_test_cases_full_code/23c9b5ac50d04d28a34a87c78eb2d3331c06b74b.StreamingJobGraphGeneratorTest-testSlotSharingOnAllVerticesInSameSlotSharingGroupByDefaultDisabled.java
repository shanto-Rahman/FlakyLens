@Test public void testSlotSharingOnAllVerticesInSameSlotSharingGroupByDefaultDisabled(){
  final StreamGraph streamGraph=createStreamGraphForSlotSharingTest();
  streamGraph.setAllVerticesInSameSlotSharingGroupByDefault(false);
  final JobGraph jobGraph=StreamingJobGraphGenerator.createJobGraph(streamGraph);
  final List<JobVertex> verticesSorted=jobGraph.getVerticesSortedTopologicallyFromSources();
  assertEquals(4,verticesSorted.size());
  final JobVertex source1Vertex=verticesSorted.get(0);
  final JobVertex source2Vertex=verticesSorted.get(1);
  final JobVertex map1Vertex=verticesSorted.get(2);
  final JobVertex map2Vertex=verticesSorted.get(3);
  assertSameSlotSharingGroup(source1Vertex,map1Vertex);
  assertDistinctSharingGroups(source1Vertex,source2Vertex,map2Vertex);
}
