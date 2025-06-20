/** 
 * Test whether Avro timestamps can be deserialized according to new behavior (storage in UTC but LocalDateTime semantics as timestamps are converted back to the writer time zone) as well as old behavior (Instant semantics).
 */
@Test public void canDeserializeTimestamps() throws SerDeException, IOException {
assertTrue(GENERIC_DATA.validate(readerSchema,record));
assertEquals(Timestamp.valueOf("2019-01-01 19:00:00.999"),resultTimestamp);
assertEquals(Timestamp.valueOf("2019-01-01 16:00:00.999"),resultTimestamp);
}