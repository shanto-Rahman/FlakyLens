@Test public void summarizeUsersReturnsListOfUsersWithoutTheCurrent(){
assertThat(users).containsExactlyInAnyOrder(UserShortSummary.create("franz","Franz Josef Strauss"),UserShortSummary.create("friedrich","Friedrich Merz"));
}