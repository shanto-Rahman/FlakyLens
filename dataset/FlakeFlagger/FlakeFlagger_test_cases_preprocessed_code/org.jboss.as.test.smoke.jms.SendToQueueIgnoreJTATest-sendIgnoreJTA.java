/** 
 * JMS message is send using connection factory with transactional = false. Message should be delivered - main reason of fix.
 */
@Test public void sendIgnoreJTA() throws Exception {
latch.await(MAX_WAIT_IN_SECONDS,SECONDS);//RW
assertEquals(0,latch.getCount());
}