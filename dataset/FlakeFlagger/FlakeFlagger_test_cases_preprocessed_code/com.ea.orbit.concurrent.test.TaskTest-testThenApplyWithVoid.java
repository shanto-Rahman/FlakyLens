@Test public void testThenApplyWithVoid(){
assertFalse(t1.isDone());
t1.complete(null);//IT
assertTrue(t2.isDone());
assertEquals("a",t2.join());
}