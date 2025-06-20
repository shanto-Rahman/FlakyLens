@Test public void test_BizException_WithType() throws Exception {
assertEquals("Hello",((BizException)read).getMessage());
}