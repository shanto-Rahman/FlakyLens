public void testProcess(){
  List<Node>[] result=SupportJoinResultNodeFactory.makeOneStreamResult(4,1,2,2);
  leafNode.process(result,new ArrayList<EventBean[]>(),null);
  assertEquals(4,parentNode.getRowsList().size());
  assertEquals(result[1].get(0).getEvents().iterator().next(),parentNode.getRowsList().get(0)[1]);
}
