public void testCreateTable() throws Exception {
assertFalse(remoteAdmin.isTableAvailable(TABLE_1));
assertTrue(remoteAdmin.isTableAvailable(TABLE_1));
}