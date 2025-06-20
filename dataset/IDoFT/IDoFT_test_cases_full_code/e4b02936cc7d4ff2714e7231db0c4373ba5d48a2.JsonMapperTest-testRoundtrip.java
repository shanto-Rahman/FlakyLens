@Test public void testRoundtrip() throws IOException {
  Map<String,String> source=new HashMap<>();
  source.put(k1,v1);
  source.put(k2,v2);
  String json=JsonMapper.toJSON(source);
  Assert.assertNotNull(json);
  Assert.assertEquals(JSON_SOURCE,json);
  Map cloned=JsonMapper.fromJSON(json,Map.class);
  Assert.assertNotNull(cloned);
  Assert.assertEquals(source,cloned);
}
