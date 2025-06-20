@Test public void testThenComposeNoParams(){
assertFalse(t1.isDone());
t1.complete(1);//IT
assertTrue(t2.isDone());
assertEquals("b",t2.join());
assertEquals("c",t3.join());
}