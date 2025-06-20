@Test public void testXmppDomainAuthentication() throws Exception {
assertNotNull(xmppAuth);
Jid user1GuestJid=JidCreate.from("user1@" + guestDomain);//RW
Jid user1AuthJid=JidCreate.from("user1@" + authDomain);//RW
Jid user2GuestJid=JidCreate.from("user2@" + guestDomain);//RW
Jid user2AuthJid=JidCreate.from("user2@" + authDomain);//RW
FocusComponent focusComponent=osgi.jicofoServices.getFocusComponent();//RW
assertNotNull(authError);
assertEquals(XMPPError.Condition.not_authorized,authError.getError().getCondition());
assertNull(authError);
assertNotNull(user1SessionId);
assertNull(authError);
assertNull(response.getSessionId());
assertNull(authError);
assertEquals(user1SessionId,response.getSessionId());
assertNotNull(authError);
assertNotNull(authError.getError().getExtension(SessionInvalidPacketExtension.ELEMENT_NAME,SessionInvalidPacketExtension.NAMESPACE));
assertNotNull(authError);
assertEquals(XMPPError.Condition.not_acceptable,authError.getError().getCondition());
assertNotNull(authError);
assertNotNull(XMPPError.Condition.not_acceptable.toString(),authError.getError().getCondition());
assertNotNull(authError);
assertNotNull(XMPPError.Condition.not_acceptable.toString(),authError.getError().getCondition());
assertNotNull(authError);
assertNotNull(XMPPError.Condition.not_acceptable.toString(),authError.getError().getCondition());
assertNull(authError);
assertNotNull(user3SessionId);
}