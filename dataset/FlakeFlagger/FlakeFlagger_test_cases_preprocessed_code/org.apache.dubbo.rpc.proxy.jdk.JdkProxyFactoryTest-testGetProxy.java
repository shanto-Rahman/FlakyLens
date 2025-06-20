@Test public void testGetProxy() throws Exception {
Assert.assertNotNull(proxy);
Assert.assertTrue(Arrays.asList(proxy.getClass().getInterfaces()).contains(DemoService.class));
Assert.assertEquals(invoker.invoke(new RpcInvocation("echo",new Class[]{String.class},new Object[]{"aa"})).getValue(),proxy.echo("aa"));
}