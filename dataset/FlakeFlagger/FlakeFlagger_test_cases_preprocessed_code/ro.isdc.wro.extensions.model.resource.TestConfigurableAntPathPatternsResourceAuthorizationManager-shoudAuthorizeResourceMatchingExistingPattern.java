@Test public void shoudAuthorizeResourceMatchingExistingPattern(){
assertTrue(victim.isAuthorized("classpath:com/site/resource/a.js"));
assertTrue(victim.isAuthorized("/a/b/c/d/e.js"));
}