public void testDAG(){
  MutableNetwork<String,Integer> graph=NetworkBuilder.directed().build();
  graph.addNode("B0");
  graph.addEdge("A","B0",0);
  graph.addEdge("A","B1",1);
  Network<String,Integer> mst=MinimumSpanningTree.extractFrom(graph,e -> 1.0);
  assertEquals(graph.nodes(),mst.nodes());
  assertEquals(graph.edges(),mst.edges());
}
