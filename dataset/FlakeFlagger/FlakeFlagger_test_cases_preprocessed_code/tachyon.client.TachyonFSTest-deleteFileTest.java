@Test public void deleteFileTest() throws IOException {
Assert.assertEquals(1,workers.size());
Assert.assertEquals(WORKER_CAPACITY_BYTES,workers.get(0).getCapacityBytes());
Assert.assertEquals(0,workers.get(0).getUsedBytes());
Assert.assertTrue(file.isInMemory());
Assert.assertTrue(mTfs.exist("/file" + k));
Assert.assertEquals(1,workers.size());
Assert.assertEquals(WORKER_CAPACITY_BYTES,workers.get(0).getCapacityBytes());
Assert.assertEquals(writeBytes * (k + 1),workers.get(0).getUsedBytes());
Assert.assertFalse(mTfs.exist("/file" + k));
Assert.assertEquals(1,workers.size());
Assert.assertEquals(WORKER_CAPACITY_BYTES,workers.get(0).getCapacityBytes());
Assert.assertEquals(writeBytes * (4 - k),workers.get(0).getUsedBytes());
}