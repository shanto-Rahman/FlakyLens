/** 
 * Test of delete method, of class MongoDBSessionDataStorage.
 */
@Test public void testDelete(){
  System.out.println("delete");
  MongoDBSessionDataStorage instance=new MongoDBSessionDataStorage(mongoClient.getDatabase(DATABASE_NAME));
  SessionData sessionData=instance.create();
  String sessionId=sessionData.getId();
  sessionData.put(KEY,VALUE);
  instance.save(sessionData);
  instance.delete(sessionId);
  SessionData deleted=instance.get(sessionId);
  assertNull(deleted);
}
