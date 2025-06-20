@Test public void test_BizExceptionNoDefaultConstructor() throws Exception {
assertEquals("Hello",((BizExceptionNoDefaultConstructor)read).getMessage());
}