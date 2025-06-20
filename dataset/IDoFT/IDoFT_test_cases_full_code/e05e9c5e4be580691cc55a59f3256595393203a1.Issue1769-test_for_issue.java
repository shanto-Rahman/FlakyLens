public void test_for_issue() throws Exception {
  byte[] newby="{\"beginTime\":\"420180319160440\"}".getBytes();
  QueryTaskResultReq rsp3=JSON.parseObject(newby,QueryTaskResultReq.class);
  assertEquals("{\"beginTime\":\"152841225111920\"}",new String(JSON.toJSONBytes(rsp3)));
}
