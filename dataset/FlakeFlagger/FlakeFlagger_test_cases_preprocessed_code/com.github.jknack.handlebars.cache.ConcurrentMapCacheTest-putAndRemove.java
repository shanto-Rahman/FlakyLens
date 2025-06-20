@Test public void putAndRemove(){
assertEquals(template,cache.get(key));
assertNull(cache.get(key));
}