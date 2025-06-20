/** 
 * scenario: explicitly configure to add attachment verify: id attribute added in attachment
 */
@Test public void testAttachInvocationIdIfAsync_forceAttache(){
assertNotNull(RpcUtils.getInvocationId(inv));
}