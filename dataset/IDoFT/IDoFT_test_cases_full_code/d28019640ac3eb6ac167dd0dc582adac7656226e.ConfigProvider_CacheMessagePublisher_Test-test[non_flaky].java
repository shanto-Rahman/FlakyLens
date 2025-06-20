@Test public void test(){
  CountBean bean=context.getBean(CountBean.class);
  MyCacheMessagePublisher publisher=context.getBean(MyCacheMessagePublisher.class);
  bean.cache.put("K1","V1");
  Assert.assertEquals(CacheMessage.TYPE_PUT,publisher.messageType);
  Assert.assertEquals("K1",publisher.keys[0]);
  SortedMap<String,String> kvs=new TreeMap(Stream.of(new String[]{"K1","V1_new"},new String[]{"K2","V2"}).collect(Collectors.toMap(kv -> kv[0],kv -> kv[1])));
  bean.cache.putAll(kvs);
  Assert.assertEquals(CacheMessage.TYPE_PUT_ALL,publisher.messageType);
  Assert.assertEquals("K1",publisher.keys[0]);
  Assert.assertEquals("K2",publisher.keys[1]);
  bean.cache.remove("K3");
  Assert.assertEquals(CacheMessage.TYPE_REMOVE,publisher.messageType);
  Assert.assertEquals("K3",publisher.keys[0]);
  SortedSet<String> keys=new TreeSet(Stream.of("K1","K3").collect(Collectors.toSet()));
  bean.cache.removeAll(keys);
  Assert.assertEquals(CacheMessage.TYPE_REMOVE_ALL,publisher.messageType);
  Assert.assertEquals("K1",publisher.keys[0]);
  Assert.assertEquals("K3",publisher.keys[1]);
}
