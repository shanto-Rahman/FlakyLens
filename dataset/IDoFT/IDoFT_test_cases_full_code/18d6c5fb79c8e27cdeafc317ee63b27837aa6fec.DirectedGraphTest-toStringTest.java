@Test public void toStringTest() throws Exception {
  final DirectedGraph<String> graph=makeGraph();
  assertThat(graph.toString(),is("digraph {\n  A;\n  B;\n  C;\n  D;\n  E;\n  A -> B;\n  B -> C;\n  A -> D;\n}\n"));
}
