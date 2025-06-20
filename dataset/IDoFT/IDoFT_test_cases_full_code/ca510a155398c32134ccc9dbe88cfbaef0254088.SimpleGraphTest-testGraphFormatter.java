@Test public void testGraphFormatter(){
  SimpleGraph mygraph=new SimpleGraph();
  List<Integer> sources=Arrays.asList(1,2,3,4,5);
  List<Integer> targets=Arrays.asList(5,4,3,2,1);
  List<String> edata=Arrays.asList("a","b","c","d","e");
  assertEquals(mygraph.numEdges(),0);
  mygraph.addEdges(sources,targets,edata);
  assertEquals(mygraph.numEdges(),sources.size());
  SimpleJsonFormatter formatter=new SimpleJsonFormatter();
  String s=formatter.structWriter(mygraph).toString();
  String expected="{\"source\":1,\"targets\":[5]}\n" + "{\"source\":2,\"targets\":[4]}\n" + "{\"source\":3,\"targets\":[3]}\n"+ "{\"source\":4,\"targets\":[2]}\n"+ "{\"source\":5,\"targets\":[1]}\n";
  assertEquals(s,expected);
  s=formatter.edataWriter(mygraph).toString();
  expected="[\"a\",\"b\",\"c\",\"d\",\"e\"]";
  assertEquals(expected,s);
}
