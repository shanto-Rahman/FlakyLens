/** 
 * test connection sharing
 */
@Test public void test_share_connect(){
Assert.assertEquals(demoClient.getLocalAddress(),helloClient.getLocalAddress());
Assert.assertEquals(demoClient,helloClient);
}