public void testMinimumServerCount() throws Exception {
assertFalse(admin.isTableEnabled(TABLE_NAME));
Thread.sleep(10 * 1000);
assertFalse(admin.isTableAvailable(TABLE_NAME));
Thread.sleep(10 * 1000);
assertTrue(admin.isTableAvailable(TABLE_NAME));
}