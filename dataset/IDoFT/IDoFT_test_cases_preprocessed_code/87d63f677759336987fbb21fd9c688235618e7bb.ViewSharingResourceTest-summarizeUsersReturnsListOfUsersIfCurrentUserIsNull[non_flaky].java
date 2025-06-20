@Test public void summarizeUsersReturnsListOfUsersIfCurrentUserIsNull(){
assertThat(users).containsExactlyInAnyOrder(UserShortSummary.create("franz","Franz Josef Strauss"),UserShortSummary.create("friedrich","Friedrich Merz"),UserShortSummary.create("peter","Peter Altmaier"));
}