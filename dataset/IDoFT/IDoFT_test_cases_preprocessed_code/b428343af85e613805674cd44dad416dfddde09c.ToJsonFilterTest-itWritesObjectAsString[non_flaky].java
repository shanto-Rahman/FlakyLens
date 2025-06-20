@Test public void itWritesObjectAsString(){
assertThat(filter.filter(testArray,interpreter)).isEqualTo("[4,1,2]");
assertThat(filter.filter(testMap,interpreter)).isEqualTo("{\"testArray\":[4,1,2],\"testString\":\"testString\"}");
}