/** 
 * scenario: sync invocation, no attachment added by default verify: no id attribute added in attachment
 */
@Test public void testAttachInvocationIdIfAsync_sync(){
assertNull(RpcUtils.getInvocationId(inv));
}