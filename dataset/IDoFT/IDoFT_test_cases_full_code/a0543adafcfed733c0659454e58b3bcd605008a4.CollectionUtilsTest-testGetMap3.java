@Test public void testGetMap3(){
  Map<String,String> map1=new HashMap(1);
  Map<String,String> map2=new HashMap(2);
  map1.put("key","value");
  map2.put("key1","value1");
  map2.put("key2","value2");
  Iterator<Map.Entry<String,String>> iter=map1.entrySet().iterator();
  Assert.assertEquals(iter.next(),CollectionUtils.get(map1,0));
  Iterator<Map.Entry<String,String>> iter2=map2.entrySet().iterator();
  iter2.next();
  Map.Entry<String,String> second=iter2.next();
  Assert.assertEquals(second,CollectionUtils.get(map2,1));
}
