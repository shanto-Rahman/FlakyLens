/** 
 * Test for several mangled header examples based on    {@link http  ://developer.yahoo.com/blogs/ydn/posts/2010/12/pushing-beyond-gzipping/}  blog post.
 */
@Test public void testGzipSupport() throws Exception {
assertFalse(WroUtil.isGzipSupported(request));
assertFalse(WroUtil.isGzipSupported(request));
assertTrue(WroUtil.isGzipSupported(request));
assertFalse(WroUtil.isGzipSupported(request));
assertTrue(WroUtil.isGzipSupported(request));
assertTrue(WroUtil.isGzipSupported(request));
assertTrue(WroUtil.isGzipSupported(request));
assertFalse(WroUtil.isGzipSupported(request));
assertTrue(WroUtil.isGzipSupported(request));
assertTrue(WroUtil.isGzipSupported(request));
assertTrue(WroUtil.isGzipSupported(request));
}