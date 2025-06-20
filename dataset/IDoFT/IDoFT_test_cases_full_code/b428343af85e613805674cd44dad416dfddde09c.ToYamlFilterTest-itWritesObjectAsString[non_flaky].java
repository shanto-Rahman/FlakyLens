@Test public void itWritesObjectAsString(){
  int[] testArray=new int[]{4,1,2};
  assertThat(filter.filter(testArray,interpreter)).isEqualTo("- 4\n" + "- 1\n" + "- 2\n");
  Map<String,Object> testMap=new LinkedHashMap<>();
  testMap.put("testArray",testArray);
  testMap.put("testString","testString");
  assertThat(filter.filter(testMap,interpreter)).isEqualTo("testArray:\n" + "- 4\n" + "- 1\n"+ "- 2\n"+ "testString: \"testString\"\n");
}
