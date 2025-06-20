@Test public void duplicateCoordinatesAtBaseOrAdjNode(){
  addNode(0,0,0);
  addNode(1,1,1);
  addEdge(0,1,true).setWayGeometry(createPointList(0.1,0.1,0.1,0.1,0.2,0.2,0.9,0.9,0.9,0.9));
  init();
  checkResult(0.1,0.1,restricted(edge(0,2),edge(2,1),edge(1,2),edge(2,0)));
  checkResult(0.9,0.9,restricted(edge(0,2),edge(2,1),edge(1,2),edge(2,0)));
}
