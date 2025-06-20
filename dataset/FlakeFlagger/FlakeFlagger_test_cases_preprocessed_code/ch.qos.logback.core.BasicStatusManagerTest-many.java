@Test public void many(){
assertNotNull(statusList);
assertEquals(MAX_HEADER_COUNT + TAIL_SIZE,statusList.size());
assertEquals(witness,statusList);
}