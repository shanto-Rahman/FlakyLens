@Test public void testCanonicalPath(){
Assert.assertEquals("/somepath",result.getRelativePath());
Assert.assertEquals("http://www.somehost.net/somepath",result.getRequestURI());
}