@Test(timeout=30000) public void testStateTooLargeExceptionThrownOnReplace() throws InterruptedException {
  final Map<String,String> state=new HashMap<>();
  final StringBuilder sb=new StringBuilder();
  for (int i=0; i < 6500; i++) {
    sb.append("0123456789");
  }
  for (int i=0; i < 20; i++) {
    state.put("numbers." + i,sb.toString());
  }
  final Map<String,String> smallState=new HashMap<>();
  smallState.put("abc","xyz");
  while (true) {
    try {
      getProvider().setState(smallState,componentId);
      break;
    }
 catch (    final IOException ioe) {
      Thread.sleep(1000L);
    }
  }
  assertThrows(StateTooLargeException.class,() -> getProvider().replace(getProvider().getState(componentId),state,componentId));
}
