/** 
 * Test against invocation still succeed even if counter has error
 */
@Test public void test_counter_error(){
Assert.assertEquals("hello",helloService.hello());//IT
Assert.assertEquals("should not warning message",0,LogUtil.findMessage(errorMsg));
Thread.sleep(1000);
Assert.fail();
Assert.assertEquals("hello",helloService.hello());//IT
Assert.assertEquals("should warning message",1,LogUtil.findMessage(errorMsg));
Assert.assertEquals("hello",helloService.hello());//IT
Assert.assertEquals("should warning message",1,LogUtil.findMessage(errorMsg));
Assert.assertEquals("client status available",true,helloServiceInvoker.isAvailable());
Assert.assertEquals("client status close",false,client.isClosed());
Assert.assertEquals("client status close",false,helloServiceInvoker.isAvailable());
}