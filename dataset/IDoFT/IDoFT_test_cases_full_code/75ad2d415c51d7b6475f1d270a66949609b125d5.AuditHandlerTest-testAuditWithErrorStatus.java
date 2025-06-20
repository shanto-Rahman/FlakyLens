@Test public void testAuditWithErrorStatus() throws Exception {
  runTest("/error","post",null,401);
  verifyAuditErrorStatus();
}
