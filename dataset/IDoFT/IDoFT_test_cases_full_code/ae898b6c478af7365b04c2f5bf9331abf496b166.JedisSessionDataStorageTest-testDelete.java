/** 
 * Test of delete method, of class JedisSessionDataStorage.
 */
@Test public void testDelete(){
  System.out.println("delete");
  JedisSessionDataStorage instance=new JedisSessionDataStorage(jedisPool);
  SessionData sessionData=instance.create();
  String sessionId=sessionData.getId();
  sessionData.put(KEY,VALUE);
  instance.save(sessionData);
  instance.delete(sessionId);
  SessionData deleted=instance.get(sessionId);
  assertNull(deleted);
}
