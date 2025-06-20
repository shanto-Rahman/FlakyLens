@Test public void testShibbolethAuthenticationModule() throws Exception {
FocusComponent focusComponent=osgi.jicofoServices.getFocusComponent();//RW
assertNotNull(shibbolethAuth);
assertNotNull(authError);
assertEquals(XMPPError.Condition.not_authorized,authError.getError().getCondition());
assertNull(authError);
assertNull(authError);
assertNotNull(authError);
assertNotNull(authError.getError().getExtension(SessionInvalidPacketExtension.ELEMENT_NAME,SessionInvalidPacketExtension.NAMESPACE));
assertNull(authError);
assertNotNull(authError);
assertEquals(XMPPError.Condition.not_acceptable,authError.getError().getCondition());
assertNotNull(authError);
assertNotNull(XMPPError.Condition.not_acceptable.toString(),authError.getError().getCondition());
assertNotNull(user3Session);
assertNull(authError);
}