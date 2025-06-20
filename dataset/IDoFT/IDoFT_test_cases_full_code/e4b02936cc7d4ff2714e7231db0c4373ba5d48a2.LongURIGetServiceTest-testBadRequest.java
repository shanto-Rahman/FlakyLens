@Test public void testBadRequest(){
  String body="whatever";
  Operation op=Operation.createPost(UriUtils.buildUri(host.getUri(),LongURIGetService.SELF_LINK)).setBody(body);
  FailureResponse failure=sender.sendAndWaitFailure(op);
  assertNotNull(failure.failure);
  assertEquals(Operation.MEDIA_TYPE_APPLICATION_JSON,failure.op.getContentType());
  assertEquals(Operation.STATUS_CODE_BAD_REQUEST,failure.op.getStatusCode());
  op=Operation.createPost(UriUtils.buildUri(host.getUri(),LongURIGetService.SELF_LINK)).setContentType("application/html").setBody(body);
  failure=sender.sendAndWaitFailure(op);
  assertNotNull(failure.failure);
  assertNotNull(failure.op.getBody(String.class));
  assertEquals(Operation.STATUS_CODE_BAD_REQUEST,failure.op.getStatusCode());
  LongURIRequest request=new LongURIRequest();
  request.uri="<script>alert(\"surprise!\");</script>";
  op=Operation.createPost(UriUtils.buildUri(host.getUri(),LongURIGetService.SELF_LINK)).setContentType("application/html").setBody(request);
  failure=sender.sendAndWaitFailure(op);
  assertNotNull(failure.failure);
  assertEquals(Operation.MEDIA_TYPE_APPLICATION_JSON,failure.op.getContentType());
  assertEquals(Operation.STATUS_CODE_NOT_FOUND,failure.op.getStatusCode());
  assertTrue(failure.op.getBody(String.class).startsWith("{\"message\":\"Service not found:"));
}
