@Test(expected=WroRuntimeException.class) public void cannotInjectUnsupportedInnerObject() throws Exception {
Assert.assertNotNull(locatorFactory);
inner.call();
outer.call();
}