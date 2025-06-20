/** 
 * Test of delete method, of class MongoDBSessionDataStorage.
 */
@Test public void testDelete(){
MongoDBSessionDataStorage instance=new MongoDBSessionDataStorage(mongoClient.getDatabase(DATABASE_NAME));//RW
assertNull(deleted);
}