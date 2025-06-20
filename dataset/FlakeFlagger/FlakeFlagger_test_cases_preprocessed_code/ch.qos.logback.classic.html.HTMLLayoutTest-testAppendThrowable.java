@Test public void testAppendThrowable() throws Exception {
assertEquals("test1: msg1",result[0]);
assertEquals(DefaultThrowableRenderer.TRACE_PREFIX + "at c1.m1(f1:1)",result[1]);
}