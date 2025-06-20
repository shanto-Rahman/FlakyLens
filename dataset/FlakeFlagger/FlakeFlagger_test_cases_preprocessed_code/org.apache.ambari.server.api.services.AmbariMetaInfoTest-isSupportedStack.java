@Test public void isSupportedStack(){
boolean supportedStack=metaInfo.isSupportedStack(STACK_VERSION_HDP,STACK_VERSION_HDP);//RW
assertTrue(supportedStack);
}