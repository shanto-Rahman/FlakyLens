@Test(expected=WroRuntimeException.class) public void noIgnoreForMissingVariables() throws Exception {
final File testFolder=new File(url.getFile(),"test");
final File expectedFolder=new File(url.getFile(),"expected");
}