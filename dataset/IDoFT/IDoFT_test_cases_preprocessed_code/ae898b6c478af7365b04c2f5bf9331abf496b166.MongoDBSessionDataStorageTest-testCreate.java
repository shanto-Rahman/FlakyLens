/** 
 * Test of create method, of class MongoDBSessionDataStorage.
 */
@Test public void testCreate(){
MongoDBSessionDataStorage instance=new MongoDBSessionDataStorage(mongoClient.getDatabase(DATABASE_NAME));//RW
assertEquals(sessionData,saved);
assertEquals(value1,value2);
}