@Test public void testEmptyPool() throws Exception {
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
Assert.assertEquals(10,totals.getMax());
Assert.assertEquals(0,stats.getAvailable());
Assert.assertEquals(0,stats.getLeased());
Assert.assertEquals(0,stats.getPending());
Assert.assertEquals(2,stats.getMax());
Assert.assertEquals("[leased: []][available: []][pending: []]",pool.toString());
}