@Test public void testEditColumnFamily() throws Exception {
assertEquals("birthdate",StringSerializer.get().fromByteBuffer(fromCluster.getCfDefs().get(0).getColumnMetadata().get(0).getName()));
}