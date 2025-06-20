/** 
 * test counter won't count down incorrectly when invoker is destroyed for multiple times
 */
@Test public void test_multi_destory(){
Assert.assertEquals("hello",helloService.hello());//IT
Assert.assertEquals("should not  warning message",0,LogUtil.findMessage(errorMsg));
}