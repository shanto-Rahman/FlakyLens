public void testQueue() throws Exception {
assertEquals(queue.heapSize(),expectedSize);
assertEquals(blocks[0].getName(),"cb1");
assertEquals(blocks[1].getName(),"cb2");
assertEquals(blocks[2].getName(),"cb3");
assertEquals(blocks[3].getName(),"cb4");
assertEquals(blocks[4].getName(),"cb5");
assertEquals(blocks[5].getName(),"cb6");
assertEquals(blocks[6].getName(),"cb7");
assertEquals(blocks[7].getName(),"cb8");
}