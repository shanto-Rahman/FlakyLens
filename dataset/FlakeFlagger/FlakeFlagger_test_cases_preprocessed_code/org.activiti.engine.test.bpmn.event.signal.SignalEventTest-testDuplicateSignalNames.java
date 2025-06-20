public void testDuplicateSignalNames(){
fail("exception expected");
if (!e.getMessage().contains(Problems.SIGNAL_DUPLICATE_NAME)) {
fail("different exception expected");
}
}