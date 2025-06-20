@Test public void test(){
Assert.assertEquals(CacheMessage.TYPE_PUT,publisher.messageType);
Assert.assertEquals("K1",publisher.keys[0]);
Assert.assertEquals(CacheMessage.TYPE_PUT_ALL,publisher.messageType);
Assert.assertEquals("K1",publisher.keys[0]);
Assert.assertEquals("K2",publisher.keys[1]);
Assert.assertEquals(CacheMessage.TYPE_REMOVE,publisher.messageType);
Assert.assertEquals("K3",publisher.keys[0]);
Assert.assertEquals(CacheMessage.TYPE_REMOVE_ALL,publisher.messageType);
Assert.assertEquals("K1",publisher.keys[0]);
Assert.assertEquals("K3",publisher.keys[1]);
}