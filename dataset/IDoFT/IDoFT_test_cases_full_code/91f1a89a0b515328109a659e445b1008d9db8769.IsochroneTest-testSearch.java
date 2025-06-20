@Test public void testSearch(){
  initDirectedAndDiffSpeed(graph);
  PMap pMap=new PMap();
  Isochrone instance=new Isochrone(graph,new FastestWeighting(carEncoder,pMap),false);
  instance.setTimeLimit(60);
  List<Set<Integer>> res=instance.search(0,5);
  assertEquals("[[0, 4], [6], [1, 7], [5], [2, 3]]",res.toString());
  instance=new Isochrone(graph,new FastestWeighting(carEncoder,pMap),false);
  instance.setTimeLimit(30);
  res=instance.search(0,5);
  assertEquals("[[0], [4], [], [6], [1, 7]]",res.toString());
}
