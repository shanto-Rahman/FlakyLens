@Test public void summarizeUsersReturnsListOfUsersIfCurrentUserIsNull(){
  this.currentUser=null;
  final User user1=mock(User.class);
  when(user1.getName()).thenReturn("franz");
  when(user1.getFullName()).thenReturn("Franz Josef Strauss");
  final User user2=mock(User.class);
  when(user2.getName()).thenReturn("friedrich");
  when(user2.getFullName()).thenReturn("Friedrich Merz");
  final User peter=mock(User.class);
  when(peter.getName()).thenReturn("peter");
  when(peter.getFullName()).thenReturn("Peter Altmaier");
  when(userService.loadAll()).thenReturn(ImmutableList.of(user1,user2,peter));
  final Set<UserShortSummary> users=this.viewSharingResource.summarizeUsers("viewId");
  assertThat(users).containsExactlyInAnyOrder(UserShortSummary.create("franz","Franz Josef Strauss"),UserShortSummary.create("friedrich","Friedrich Merz"),UserShortSummary.create("peter","Peter Altmaier"));
}
