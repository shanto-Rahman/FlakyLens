@SuppressWarnings("unchecked") @Test public void testInvokeByPassingNullValue() throws RemotingException {
given(mockInvoker.invoke(any(Invocation.class))).willReturn(new RpcResult("ok"));//RW
invoke.telnet(mockChannel,"DemoService.add(null, 2)");//RW
fail("It should cause a NullPointerException by the above code.");
assertEquals("The type of No.1 parameter is primitive(int), but the value passed is null.",message);
invoke.telnet(mockChannel,"DemoService.add(1, null)");//RW
fail("It should cause a NullPointerException by the above code.");
assertEquals("The type of No.2 parameter is primitive(long), but the value passed is null.",message);
invoke.telnet(mockChannel,"DemoService.sayHello(null)");//RW
fail("It shouldn't cause a NullPointerException by the above code.");
}