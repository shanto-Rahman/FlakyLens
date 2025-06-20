@Test public void itWritesObjectAsString(){
  int[] testArray=new int[]{4,1,2};
  assertThat(filter.filter(testArray,interpreter)).isEqualTo("[4,1,2]");
  Map<String,Object> testMap=new HashMap<>();
  testMap.put("testArray",testArray);
  testMap.put("testString","testString");
  assertThat(filter.filter(testMap,interpreter)).isEqualTo("{\"testArray\":[4,1,2],\"testString\":\"testString\"}");
}
