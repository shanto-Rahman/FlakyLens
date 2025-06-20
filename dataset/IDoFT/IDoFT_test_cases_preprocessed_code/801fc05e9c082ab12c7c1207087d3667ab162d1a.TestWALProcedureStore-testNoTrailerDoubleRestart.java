@Test public void testNoTrailerDoubleRestart() throws Exception {
assertEquals(4,logs.length);
assertEquals(1,loader.getLoadedCount());
assertEquals(0,loader.getCorruptedCount());
assertEquals(5,fs.listStatus(logDir).length);
assertEquals(1,loader.getLoadedCount());
assertEquals(0,loader.getCorruptedCount());
assertEquals(1,fs.listStatus(logDir).length);
}