@Test public void testAllOfVariations(){
t1.complete(1);//IT
t2.completeExceptionally(new RuntimeException());//IT
t3.complete(3);//IT
c4.complete(4);
assertTrue(all_regular.isDone());
assertTrue(all_array.isDone());
assertTrue(all_array2.isDone());
assertTrue(all_stream.isDone());
assertTrue(all_stream2.isDone());
assertTrue(all_stream3.isDone());
assertTrue(all_stream4.isDone());
assertTrue(all_stream5.isDone());
assertTrue(all_collection.isDone());
}