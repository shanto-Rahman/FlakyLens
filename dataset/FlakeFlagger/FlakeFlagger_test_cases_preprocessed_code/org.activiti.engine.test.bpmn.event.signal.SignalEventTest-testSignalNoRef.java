public void testSignalNoRef(){
fail("exception expected");
if (!e.getMessage().contains(Problems.SIGNAL_EVENT_MISSING_SIGNAL_REF)) {
fail("different exception expected");
}
}