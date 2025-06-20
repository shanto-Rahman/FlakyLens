@Test public void testSubMap() throws IOException {
client.put(key + i,value + i,serializer,serializer);//RW
final Map<String,String> subMap=client.subMap(keys,serializer,deserializer);//RW
assertEquals(3,subMap.size());
assertEquals(value + i,subMap.get(key + i));
}