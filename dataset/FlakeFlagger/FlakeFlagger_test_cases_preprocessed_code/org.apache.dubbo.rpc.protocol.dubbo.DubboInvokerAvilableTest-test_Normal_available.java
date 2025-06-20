@Test public void test_Normal_available(){
DubboInvoker<?> invoker=(DubboInvoker<?>)protocol.refer(IDemoService.class,url);//RW
Assert.assertEquals(true,invoker.isAvailable());
Assert.assertEquals(false,invoker.isAvailable());
}