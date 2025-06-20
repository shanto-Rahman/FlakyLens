@Test public void readSettingsFrame() throws IOException {
assertFalse(clearPrevious);
assertEquals(reducedTableSizeBytes,settings.getHeaderTableSize());
assertEquals(false,settings.getEnablePush(true));
}