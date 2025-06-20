@Test public void testBadRequest(){
assertNotNull(failure.failure);
assertEquals(Operation.MEDIA_TYPE_APPLICATION_JSON,failure.op.getContentType());
assertEquals(Operation.STATUS_CODE_BAD_REQUEST,failure.op.getStatusCode());
assertNotNull(failure.failure);
assertNotNull(failure.op.getBody(String.class));
assertEquals(Operation.STATUS_CODE_BAD_REQUEST,failure.op.getStatusCode());
assertNotNull(failure.failure);
assertEquals(Operation.MEDIA_TYPE_APPLICATION_JSON,failure.op.getContentType());
assertEquals(Operation.STATUS_CODE_NOT_FOUND,failure.op.getStatusCode());
assertTrue(failure.op.getBody(String.class).startsWith("{\"message\":\"Service not found:"));
}