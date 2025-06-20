@Test public void testLeaseReleaseStateful() throws Exception {
Assert.assertNotNull(entry1);
Assert.assertNotNull(entry2);
Assert.assertNotNull(entry3);
Assert.assertEquals(entry2,pool.getFree(Boolean.FALSE));
Assert.assertEquals(entry1,pool.getFree(Boolean.FALSE));
Assert.assertEquals(entry3,pool.getFree(null));
Assert.assertEquals(null,pool.getFree(null));
Assert.assertEquals(null,pool.getFree(null));
Assert.assertEquals(entry2,pool.getFree(Boolean.FALSE));
Assert.assertEquals(null,pool.getFree(Boolean.FALSE));
Assert.assertEquals(entry1,pool.getFree(Boolean.TRUE));
Assert.assertEquals(entry3,pool.getFree(Boolean.TRUE));
Assert.assertEquals(null,pool.getFree(Boolean.TRUE));
}