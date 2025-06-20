@Test public void testJavaSet(){
  Collection<Integer> b=new HashSet<>();
  fillCollection(b);
  runTests(b);
}
