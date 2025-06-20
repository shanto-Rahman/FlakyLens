@Test public void testThenCompose(){
assertFalse(t1.isDone());
t1.complete(1);//IT
assertTrue(t2.isDone());
assertEquals("1a",t2.join());
assertEquals("1a",t3.join());
}