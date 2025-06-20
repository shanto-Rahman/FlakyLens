/** 
 * This test must be placed FIRST. Please don't change the order.
 * @throws Exception
 */
@Test public void testTimeUUIDWithClockResolution() throws Exception {
assertEquals(TimeUUIDUtils.getTimeUUID(time),java.util.UUID.fromString(new com.eaio.uuid.UUID(UUIDGen.createTime(time),UUIDGen.getClockSeqAndNode()).toString()));
assertTrue(second.compareTo(first) > 0);
}