@Test public void shouldSerializeToTreeJson() throws Exception {
  final TinkerGraph graph=TinkerFactory.createClassic();
  final GraphTraversalSource g=graph.traversal();
  final Map t=g.V(1).out().properties("name").tree().next();
  final ResponseMessage response=convert(t);
  assertCommon(response);
  final Tree deserializedTree=(Tree)response.getResult().getData();
  assertEquals(1,deserializedTree.size());
  final Vertex v=((Vertex)deserializedTree.keySet().iterator().next());
  assertEquals(1,v.id());
  assertEquals("marko",v.property("name").value());
  final Tree firstTree=(Tree)deserializedTree.get(v);
  assertEquals(3,firstTree.size());
  Iterator<Vertex> vertexKeys=firstTree.keySet().iterator();
  Tree t2=(Tree)firstTree.get(vertexKeys.next());
  VertexProperty vp=(VertexProperty)t2.keySet().iterator().next();
  assertEquals(3,vp.id());
  assertEquals("vadas",vp.value());
  t2=(Tree)firstTree.get(vertexKeys.next());
  vp=(VertexProperty)t2.keySet().iterator().next();
  assertEquals(5,vp.id());
  assertEquals("lop",vp.value());
  t2=(Tree)firstTree.get(vertexKeys.next());
  vp=(VertexProperty)t2.keySet().iterator().next();
  assertEquals(7,vp.id());
  assertEquals("josh",vp.value());
}
