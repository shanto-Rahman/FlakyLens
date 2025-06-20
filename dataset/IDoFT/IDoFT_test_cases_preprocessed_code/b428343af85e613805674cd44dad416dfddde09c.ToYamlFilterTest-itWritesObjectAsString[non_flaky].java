@Test public void itWritesObjectAsString(){
assertThat(filter.filter(testArray,interpreter)).isEqualTo("- 4\n" + "- 1\n" + "- 2\n");
assertThat(filter.filter(testMap,interpreter)).isEqualTo("testArray:\n" + "- 4\n" + "- 1\n"+ "- 2\n"+ "testString: \"testString\"\n");
}