/** 
 * This test executes a series of delayed GETs, ensuring the   {@link NHttpResponseTrigger}  works correctly.
 */
@Test public void testDelayedHttpGets() throws Exception {
if (idx == -1) {
}
new Thread(){
  @Override public void run(){
    try {
      Thread.sleep(10);
    }
 catch (    InterruptedException ie) {
    }
    try {
      NStringEntity entity=new NStringEntity(content,"US-ASCII");
      response.setEntity(entity);
    }
 catch (    UnsupportedEncodingException ex) {
    }
    trigger.submitResponse(response);
  }
}
.start();
Thread.sleep(10);
}