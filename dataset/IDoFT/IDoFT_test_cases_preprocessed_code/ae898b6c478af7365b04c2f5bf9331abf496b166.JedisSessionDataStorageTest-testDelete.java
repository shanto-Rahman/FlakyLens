/** 
 * Test of delete method, of class JedisSessionDataStorage.
 */
@Test public void testDelete(){
JedisSessionDataStorage instance=new JedisSessionDataStorage(jedisPool);//RW
assertNull(deleted);
}