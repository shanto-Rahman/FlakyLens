@Test public void testExpiry() throws Exception {
Assert.assertEquals(Long.MAX_VALUE,entry1.getExpiry());
Assert.assertEquals(entry1.getUpdated() + 50L,entry1.getExpiry());
Assert.assertEquals(Long.MAX_VALUE,entry1.getExpiry());
Assert.assertEquals(entry2.getCreated() + 100L,entry2.getExpiry());
Assert.assertEquals(entry2.getCreated() + 100L,entry2.getExpiry());
Assert.assertEquals(entry2.getUpdated() + 50L,entry2.getExpiry());
}