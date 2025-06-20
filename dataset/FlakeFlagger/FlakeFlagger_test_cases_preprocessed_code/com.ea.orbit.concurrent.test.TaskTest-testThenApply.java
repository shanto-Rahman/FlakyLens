@Test public void testThenApply(){
assertFalse(t1.isDone());
t1.complete(1);//IT
assertTrue(t2.isDone());
assertEquals("a",t2.join());
}