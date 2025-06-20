@Test public void testMaxLimits() throws Exception {
LocalPoolEntry entry1=future1.get();
Assert.assertNotNull(entry1);
LocalPoolEntry entry2=future2.get();
Assert.assertNotNull(entry2);
LocalPoolEntry entry3=future3.get();
Assert.assertNotNull(entry3);
Assert.assertEquals(3,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
Assert.assertTrue(future4.isDone());
LocalPoolEntry entry4=future4.get();
Assert.assertNotNull(entry4);
Assert.assertTrue(future5.isDone());
LocalPoolEntry entry5=future5.get();
Assert.assertNotNull(entry5);
Assert.assertTrue(future6.isDone());
LocalPoolEntry entry6=future6.get();
Assert.assertNotNull(entry6);
Assert.assertFalse(future7.isDone());
Assert.assertFalse(future8.isDone());
Assert.assertFalse(future9.isDone());
Assert.assertTrue(future7.isDone());
Assert.assertFalse(future8.isDone());
Assert.assertTrue(future9.isDone());
}