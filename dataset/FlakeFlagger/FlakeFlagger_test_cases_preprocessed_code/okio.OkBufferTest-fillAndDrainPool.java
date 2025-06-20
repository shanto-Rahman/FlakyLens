@Test public void fillAndDrainPool() throws Exception {
assertEquals(0,SegmentPool.INSTANCE.byteCount);
assertEquals(SegmentPool.MAX_SIZE,SegmentPool.INSTANCE.byteCount);
assertEquals(SegmentPool.MAX_SIZE,SegmentPool.INSTANCE.byteCount);
assertEquals(0,SegmentPool.INSTANCE.byteCount);
assertEquals(0,SegmentPool.INSTANCE.byteCount);
}