@Test(expected=IllegalStateException.class) public void test_compileJavaClass0() throws Exception {
Assert.assertEquals("Hello world!",sayHello.invoke(instance));
}