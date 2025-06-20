@Test(timeout=30000) public void testStateTooLargeExceptionThrownOnSetState() throws InterruptedException {
  final Map<String,String> state=new HashMap<>();
  final StringBuilder sb=new StringBuilder();
  for (int i=0; i < 6500; i++) {
    sb.append("0123456789");
  }
  for (int i=0; i < 20; i++) {
    state.put("numbers." + i,sb.toString());
  }
  while (true) {
    try {
      getProvider().setState(state,componentId);
      Assert.fail("Expected StateTooLargeException");
    }
 catch (    final StateTooLargeException stle) {
      break;
    }
catch (    final IOException ioe) {
      Thread.sleep(1000L);
    }
catch (    final Exception e) {
      Assert.fail("Expected StateTooLargeException but " + e.getClass() + " was thrown",e);
    }
  }
}
