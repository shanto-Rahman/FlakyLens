public void testNoSignalName(){
fail("exception expected");
if (!e.getMessage().contains(Problems.SIGNAL_MISSING_NAME)) {
fail("different exception expected, was " + e.getMessage());
}
}