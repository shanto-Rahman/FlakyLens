public void testSeekTo() throws Exception {
assertEquals(2,reader.blockIndex.count);
assertEquals(-1,scanner.seekTo(Bytes.toBytes("a")));
assertEquals(1,scanner.seekTo(Bytes.toBytes("d")));
assertEquals("c",scanner.getKeyString());
assertEquals(1,scanner.seekTo(Bytes.toBytes("h")));
assertEquals("g",scanner.getKeyString());
assertEquals(1,scanner.seekTo(Bytes.toBytes("l")));
assertEquals("k",scanner.getKeyString());
}