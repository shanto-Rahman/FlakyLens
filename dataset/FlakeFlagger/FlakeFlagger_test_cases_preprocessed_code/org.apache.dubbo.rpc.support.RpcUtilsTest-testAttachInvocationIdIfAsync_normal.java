/** 
 * regular scenario: async invocation in URL verify: 1. whether invocationId is set correctly, 2. idempotent or not
 */
@Test public void testAttachInvocationIdIfAsync_normal(){
assertTrue(id1 == id2);
assertTrue(id1 >= 0);
assertEquals("bb",attachments.get("aa"));
}