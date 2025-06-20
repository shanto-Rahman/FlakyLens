@Test public void testAllocateConference() throws Exception {
  EntityBareJid roomName=JidCreate.entityBareFrom("testRoom@example.com");
  FocusComponent focusComponent=osgi.jicofoServices.getFocusComponent();
  ConferenceIq conferenceIq=new ConferenceIq();
  conferenceIq.setRoom(roomName);
  IQ result=focusComponent.handleIQSetImpl(IQUtils.convert(conferenceIq));
  assertNotNull(result);
  org.jivesoftware.smack.packet.IQ response=IQUtils.convert(result);
  assertTrue(response instanceof ConferenceIq);
}
