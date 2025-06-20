@Test public void testCompareTo(){
Assert.assertTrue(a.compareTo(b) < 0);
Assert.assertTrue(b.compareTo(a) > 0);
Assert.assertTrue(b.compareTo(b) == 0);
Assert.assertTrue(b.resolve("key").compareTo(b) < 0);
Assert.assertTrue(b.compareTo(b.resolve("key")) > 0);
}