/** 
 * test connection not sharing
 */
@Test public void test_not_share_connect(){
Assert.assertNotSame(demoClient.getLocalAddress(),helloClient.getLocalAddress());
Assert.assertNotSame(demoClient,helloClient);
}