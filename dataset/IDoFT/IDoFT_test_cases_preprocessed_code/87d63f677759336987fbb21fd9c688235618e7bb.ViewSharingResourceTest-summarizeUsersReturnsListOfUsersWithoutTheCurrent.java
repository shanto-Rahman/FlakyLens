@Test public void summarizeUsersReturnsListOfUsersWithoutTheCurrent(){
assertThat(users).containsExactly(UserShortSummary.create("franz","Franz Josef Strauss"),UserShortSummary.create("friedrich","Friedrich Merz"));
}