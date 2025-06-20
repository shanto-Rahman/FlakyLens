@Test public void findContext(){
assertSame(this.host,result.getHost());
assertSame(expectedPath,result.getPath());
assertNull(result);
}