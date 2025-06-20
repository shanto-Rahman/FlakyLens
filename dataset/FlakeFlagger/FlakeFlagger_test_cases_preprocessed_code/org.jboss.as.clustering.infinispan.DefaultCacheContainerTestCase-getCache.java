@Test public void getCache(){
assertNotSame(cache,result);
assertEquals(result,cache);
assertSame(this.subject,result.getCacheManager());
}