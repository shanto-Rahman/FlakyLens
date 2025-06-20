/** 
 * Test of get method, of class MongoDBSessionDataStorage.
 */
@Test public void testGet(){
MongoDBSessionDataStorage instance=new MongoDBSessionDataStorage(mongoClient.getDatabase(DATABASE_NAME));//RW
assertEquals(sessionData,saved);
assertEquals(value1,value2);
}