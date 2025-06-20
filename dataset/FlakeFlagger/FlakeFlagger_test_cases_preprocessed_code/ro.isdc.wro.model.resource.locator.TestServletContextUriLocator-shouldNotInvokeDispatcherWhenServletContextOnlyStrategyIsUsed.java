@Test(expected=IOException.class) public void shouldNotInvokeDispatcherWhenServletContextOnlyStrategyIsUsed() throws Exception {
dispatcherInvokedFlag.set(true);
assertFalse(dispatcherInvokedFlag.get());
}