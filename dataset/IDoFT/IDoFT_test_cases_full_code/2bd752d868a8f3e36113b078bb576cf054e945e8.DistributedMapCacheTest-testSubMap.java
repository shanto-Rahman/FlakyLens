@Test public void testSubMap() throws IOException {
  final String key="keySubMap";
  final String value="valueSubMap";
  for (int i=0; (i < 3); ++i) {
    client.put(key + i,value + i,serializer,serializer);
  }
  final Set<String> keys=new HashSet<>(Arrays.asList("keySubMap0","keySubMap1","keySubMap2"));
  final Map<String,String> subMap=client.subMap(keys,serializer,deserializer);
  assertEquals(3,subMap.size());
  for (int i=0; (i < 3); ++i) {
    assertEquals(value + i,subMap.get(key + i));
  }
}
