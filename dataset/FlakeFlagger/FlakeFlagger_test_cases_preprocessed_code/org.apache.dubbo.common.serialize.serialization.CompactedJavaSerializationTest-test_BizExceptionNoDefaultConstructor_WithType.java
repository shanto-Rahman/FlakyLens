@Test public void test_BizExceptionNoDefaultConstructor_WithType() throws Exception {
assertEquals("Hello",((BizExceptionNoDefaultConstructor)read).getMessage());
}