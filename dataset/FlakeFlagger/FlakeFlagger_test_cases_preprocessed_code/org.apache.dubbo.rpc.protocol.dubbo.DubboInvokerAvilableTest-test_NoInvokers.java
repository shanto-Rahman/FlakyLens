@Test public void test_NoInvokers() throws Exception {
DubboInvoker<?> invoker=(DubboInvoker<?>)protocol.refer(IDemoService.class,url);//RW
Assert.assertEquals(false,invoker.isAvailable());
}