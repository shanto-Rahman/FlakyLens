public void testConnectedComponents(){
  System.out.println("graph is " + graph.toString());
  Set<Set<Integer>> ccs=new HashSet<>(graph.getConnectedComponents());
  for (  Set<Integer> cc : ccs) {
    System.out.println("Connected component: " + cc);
  }
  Set<Integer> edge1=new HashSet<>(Arrays.asList(1,2,3,4));
  Set<Integer> edge2=new HashSet<>(Arrays.asList(5,6,7));
  Set<Integer> edge3=new HashSet<>(Arrays.asList(8));
  Set<Integer> edge4=new HashSet<>(Arrays.asList(9,10));
  Set<Set<Integer>> expectedCcs=new HashSet<>(Arrays.asList(edge1,edge2,edge3,edge4));
  assertEquals(expectedCcs,ccs);
}
