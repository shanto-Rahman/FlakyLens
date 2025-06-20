public void testDeleteTable() throws Exception {
assertTrue(remoteAdmin.isTableAvailable(TABLE_2));
assertFalse(remoteAdmin.isTableAvailable(TABLE_2));
}