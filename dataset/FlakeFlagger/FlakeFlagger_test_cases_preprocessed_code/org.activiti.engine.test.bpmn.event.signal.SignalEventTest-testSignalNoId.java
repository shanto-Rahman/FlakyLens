public void testSignalNoId(){
fail("exception expected");
if (!e.getMessage().contains(Problems.SIGNAL_MISSING_ID)) {
fail("different exception expected");
}
}