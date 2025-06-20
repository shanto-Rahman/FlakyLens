@Test(expected=IllegalStateException.class) public void doNotFindGetterWithArgument() throws Exception {
fail("Should have thrown exception - getC is not a getter");
}