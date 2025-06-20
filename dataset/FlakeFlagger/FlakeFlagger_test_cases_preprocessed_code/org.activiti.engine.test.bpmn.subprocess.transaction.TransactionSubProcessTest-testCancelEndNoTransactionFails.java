public void testCancelEndNoTransactionFails(){
fail("exception expected");
if (!e.getMessage().contains("end event with cancelEventDefinition only supported inside transaction subprocess")) {
fail("different exception expected");
}
}