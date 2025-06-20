@Test(expected=IllegalStateException.class) public void testCompileJavaClass1() throws Exception {
Assert.assertEquals("Hello world!",sayHello.invoke(instance));
}