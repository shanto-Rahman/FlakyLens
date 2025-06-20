@Test public void shouldInvokeDecoratedProcessor() throws Exception {
Assert.assertEquals("\nalert(1);",writer.toString());
}