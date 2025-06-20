/** 
 * scenario: async invocation, add attachment by default verify: no error report when the original attachment is null
 */
@Test public void testAttachInvocationIdIfAsync_nullAttachments(){
assertTrue(RpcUtils.getInvocationId(inv) >= 0l);
}