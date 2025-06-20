@Test public void testReadUsersWithPagedByIdentityResponse() throws IOException {
  JsonNode jsonResponse=readResponseUserAsJsonNodeFromFile("read_users_identity_paging.json");
  String startId="aaaa";
  wireMockServer.stubFor(get(urlEqualTo(String.format("/Users?startId=%s&count=100",startId))).willReturn(configureMockedResponse(OK,jsonResponse)));
  SCIMResponse<PagedByIdentitySearchResult<User>> resp=SCIMClientService.builder(DEFAULT_URL).build().buildUserRequest().readMultipleUsers(identityPageQuery().withStartId(startId).withCount(100));
  PagedByIdentitySearchResult<User> receivedResponse=resp.get();
  assertAll(() -> assertAll(getPagedByIdentityResponseAssertions(receivedResponse)),() -> {
    User user=receivedResponse.getResources().stream().findAny().orElseThrow(RuntimeException::new);
    assertAll("Common resourceAttributes",getCommonResourceAssertions(user,User.SCHEMA));
    assertAll(() -> assertNotNull(user.getUserName()),() -> assertNotNull(user.getDisplayName()),() -> assertNotNull(user.isActive()));
  }
);
}
