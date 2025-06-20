@Test public void testDecodeRequest() throws Exception {
Assert.assertTrue(obj instanceof Request);
Assert.assertTrue(obj instanceof RpcInvocation);
Assert.assertEquals("echoString",invocation.getMethodName());
Assert.assertArrayEquals(new Class[]{String.class},invocation.getParameterTypes());
Assert.assertArrayEquals(new Object[]{args.getArg()},invocation.getArguments());
}