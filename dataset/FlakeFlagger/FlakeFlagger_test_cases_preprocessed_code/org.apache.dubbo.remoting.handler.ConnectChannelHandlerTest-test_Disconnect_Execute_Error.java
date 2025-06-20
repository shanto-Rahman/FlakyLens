@Test(expected=ExecutionException.class) public void test_Disconnect_Execute_Error() throws RemotingException {
executor.shutdown();
}