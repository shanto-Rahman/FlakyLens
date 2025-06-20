@Test public void testReflectionHierarchyArrayList(){
  final List<Object> list=new ArrayList<>(ARRAYLIST_INITIAL_CAPACITY);
  final String baseString=this.toBaseString(list);
  final String expectedWithTransients=baseString + "[elementData={<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>},size=0,modCount=0]";
  final String toStringWithTransients=ToStringBuilder.reflectionToString(list,null,true);
  if (!expectedWithTransients.equals(toStringWithTransients)) {
    assertEquals(expectedWithTransients,toStringWithTransients);
  }
  final String expectedWithoutTransients=baseString + "[size=0]";
  final String toStringWithoutTransients=ToStringBuilder.reflectionToString(list,null,false);
  if (!expectedWithoutTransients.equals(toStringWithoutTransients)) {
    assertEquals(expectedWithoutTransients,toStringWithoutTransients);
  }
}
