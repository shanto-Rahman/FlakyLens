@Deprecated @Test public void getCacheFromTemplate(){
assertNotSame(cache,result);
assertEquals(result,cache);
assertSame(this.subject,result.getCacheManager());
}