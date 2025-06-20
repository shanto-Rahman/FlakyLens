/** 
 * JMS message is send using connection factory with transactional = true. Messaging behaves as a part of JTA transaction, message should be delivered.
 */
@Test public void sendInJTA() throws Exception {
latch.await(MAX_WAIT_IN_SECONDS,SECONDS);//RW
assertEquals(0,latch.getCount());
}