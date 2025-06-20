@SuppressWarnings("serial") @Test public void testGetRequestAndTaskStatus() throws AmbariException {
assertEquals(requestId,requestStatusResponse.getRequestId());
assertEquals(2,requestStatusResponse.getTasks().size());
assertEquals(RoleCommand.START.toString(),task1.getCommand());
assertEquals(Role.HBASE_MASTER.toString(),task1.getRole());
assertEquals(2,taskStatusResponses.size());
}