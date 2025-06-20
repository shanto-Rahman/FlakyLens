@Test public void testThenReturnWithException(){
assertFalse(t1.isDone());
t1.completeExceptionally(new RuntimeException());//IT
assertTrue(t2.isDone());
assertTrue(t2.isCompletedExceptionally());
}