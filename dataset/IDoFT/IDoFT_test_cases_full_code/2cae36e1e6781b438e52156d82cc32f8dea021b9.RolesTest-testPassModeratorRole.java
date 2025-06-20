@Test public void testPassModeratorRole() throws Exception {
  EntityBareJid roomName=JidCreate.entityBareFrom("testroom@conference.pawel.jitsi.net");
  String serverName="test-server";
  TestConference testConference=TestConference.allocate(osgi.bc,serverName,roomName);
  MockProtocolProvider pps=testConference.getFocusProtocolProvider();
  MockMultiUserChatOpSet mucOpSet=pps.getMockChatOpSet();
  MockMultiUserChat chat=(MockMultiUserChat)mucOpSet.findRoom(roomName.toString());
  MockParticipant[] users=new MockParticipant[4];
  for (int i=0; i < users.length; i++) {
    users[i]=new MockParticipant("User" + i);
    users[i].join(chat);
  }
  for (  MockParticipant user : users) {
    assertNotNull(user.acceptInvite(10000));
  }
  for (int i=0; i < users.length; i++) {
    assertTrue(i + " user should have moderator role(" + users[i].getNickname()+ ")",ChatRoomMemberRole.MODERATOR.compareTo(users[i].getChatMember().getRole()) >= 0);
    users[i].leave();
  }
  testConference.stop();
}
