@Test public void testCollision(){
Assert.assertEquals("a",headerMap.getFirst(new HttpString("Link")));
Assert.assertEquals("b",headerMap.getFirst(new HttpString("Rest")));
Assert.assertEquals("a",headerMap.getFirst("Link"));
Assert.assertEquals("b",headerMap.getFirst("Rest"));
}