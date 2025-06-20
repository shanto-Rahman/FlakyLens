@Test public void testGetInvoker() throws Exception {
Assert.assertEquals(invoker.getInterface(),DemoService.class);
Assert.assertEquals(invoker.invoke(new RpcInvocation("echo",new Class[]{String.class},new Object[]{"aa"})).getValue(),origin.echo("aa"));
}