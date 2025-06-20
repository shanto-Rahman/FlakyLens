@Test public void testAllOfWithError(){
assertFalse(all.isDone());
t1.complete(1);//IT
assertFalse(all.isDone());
t2.completeExceptionally(new RuntimeException());//IT
assertFalse(all.isDone());
t3.complete(3);//IT
assertTrue(all.isDone());
}