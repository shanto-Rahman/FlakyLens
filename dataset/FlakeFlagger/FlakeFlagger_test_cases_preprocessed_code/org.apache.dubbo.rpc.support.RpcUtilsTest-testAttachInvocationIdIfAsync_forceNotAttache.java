/** 
 * scenario: explicitly configure to not add attachment verify: no id attribute added in attachment
 */
@Test public void testAttachInvocationIdIfAsync_forceNotAttache(){
assertNull(RpcUtils.getInvocationId(inv));
}