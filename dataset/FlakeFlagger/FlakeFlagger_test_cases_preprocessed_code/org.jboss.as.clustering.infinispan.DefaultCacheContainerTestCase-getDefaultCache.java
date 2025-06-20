@Test public void getDefaultCache(){
assertNotSame(cache,result);
assertEquals(result,cache);
assertSame(this.subject,result.getCacheManager());
}