public void test_max_buf() throws Exception {
  SerializeWriter writer=new SerializeWriter();
  Throwable error=null;
  try {
    writer.setMaxBufSize(1);
  }
 catch (  JSONException e) {
    error=e;
  }
  assertNotNull(error);
}
