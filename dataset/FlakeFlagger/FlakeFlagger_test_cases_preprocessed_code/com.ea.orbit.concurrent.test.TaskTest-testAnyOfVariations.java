@Test public void testAnyOfVariations(){
t1.complete(1);//IT
c4.complete(4);
assertTrue(group_regular.isDone());
assertTrue(group_array.isDone());
assertTrue(group_array2.isDone());
assertTrue(group_stream.isDone());
assertTrue(group_stream2.isDone());
assertTrue(group_stream3.isDone());
assertTrue(group_stream4.isDone());
assertTrue(group_stream5.isDone());
assertTrue(group_collection.isDone());
}