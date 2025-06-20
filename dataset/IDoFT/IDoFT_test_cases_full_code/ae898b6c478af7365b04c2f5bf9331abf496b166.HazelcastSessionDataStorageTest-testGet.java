/** 
 * Test of get method, of class HazelcastSessionDataStorage.
 */
@Test public void testGet(){
  System.out.println("get");
  HazelcastSessionDataStorage instance=new HazelcastSessionDataStorage(Hazelcast.newHazelcastInstance());
  SessionData sessionData=instance.create();
  String sessionId=sessionData.getId();
  sessionData.put(KEY,VALUE);
  instance.save(sessionData);
  SessionData saved=instance.get(sessionId);
  assertEquals(sessionData,saved);
  String value1=sessionData.get(KEY);
  String value2=saved.get(KEY);
  assertEquals(value1,value2);
}
