@Test public void testPassModeratorRole() throws Exception {
TestConference testConference=TestConference.allocate(osgi.bc,serverName,roomName);//RW
assertNotNull(user.acceptInvite(10000));
assertTrue(i + " user should have moderator role(" + users[i].getNickname()+ ")",ChatRoomMemberRole.MODERATOR.compareTo(users[i].getChatMember().getRole()) >= 0);
}