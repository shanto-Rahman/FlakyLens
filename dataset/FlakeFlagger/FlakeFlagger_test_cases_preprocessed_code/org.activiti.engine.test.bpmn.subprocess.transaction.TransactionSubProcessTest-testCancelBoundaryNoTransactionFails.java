public void testCancelBoundaryNoTransactionFails(){
fail("exception expected");
if (!e.getMessage().contains("boundary event with cancelEventDefinition only supported on transaction subprocesses")) {
fail("different exception expected");
}
}