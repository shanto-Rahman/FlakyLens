@Test public void testAllOf(){
assertFalse(all.isDone());
t1.complete(1);//IT
assertFalse(all.isDone());
t2.complete(2);//IT
t3.complete(3);//IT
assertTrue(all.isDone());
}