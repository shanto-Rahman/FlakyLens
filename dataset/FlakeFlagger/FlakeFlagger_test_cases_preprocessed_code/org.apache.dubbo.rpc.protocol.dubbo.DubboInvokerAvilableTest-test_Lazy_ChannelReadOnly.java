@Test public void test_Lazy_ChannelReadOnly() throws Exception {
DubboInvoker<?> invoker=(DubboInvoker<?>)protocol.refer(IDemoService.class,url);//RW
Assert.assertEquals(true,invoker.isAvailable());
fail();
IDemoService service=(IDemoService)proxy.getProxy(invoker);//RW
Assert.assertEquals("ok",service.get());
Assert.assertEquals(true,invoker.isAvailable());
Assert.assertEquals(false,invoker.isAvailable());
}