/** 
 * Test of save method, of class HazelcastSessionDataStorage.
 */
@Test public void testSave(){
  HazelcastInstance hazelcastInstance1=Hazelcast.newHazelcastInstance();
  HazelcastInstance hazelcastInstance2=Hazelcast.newHazelcastInstance();
  System.out.println("save");
  HazelcastSessionDataStorage instance=new HazelcastSessionDataStorage(hazelcastInstance1);
  SessionData sessionData=instance.create();
  String sessionId=sessionData.getId();
  sessionData.put(KEY,VALUE);
  instance.save(sessionData);
  SessionData saved=hazelcastInstance2.<String,SessionData>getMap(SESSION_NAME).get(sessionId);
  assertEquals(sessionData,saved);
}
