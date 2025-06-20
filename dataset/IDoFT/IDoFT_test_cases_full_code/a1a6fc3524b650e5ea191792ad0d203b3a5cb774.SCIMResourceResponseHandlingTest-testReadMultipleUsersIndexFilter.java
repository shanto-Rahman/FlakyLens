@Test public void testReadMultipleUsersIndexFilter() throws JsonProcessingException {
  int totalUsersCount=150;
  int returnedUsersCount=50;
  int startIndex=30;
  wireMockServer.stubFor(get(urlEqualTo(String.format("/Users?startIndex=%d&count=%d",startIndex,returnedUsersCount))).willReturn(configureMockedResponse(OK,APPLICATION_JSON_SCIM,new PagedByIndexSearchResult<>(new PagedResult<>(totalUsersCount,generateUsers(returnedUsersCount)),startIndex))));
  final SCIMResponse<PagedByIndexSearchResult<User>> usersResult=SCIMClientService.builder(DEFAULT_URL).build().buildUserRequest().readMultipleUsers(indexPageQuery().withStartIndex(startIndex).withCount(returnedUsersCount));
  assertAll(() -> {
    assertTrue(usersResult.isSuccess());
    PagedByIndexSearchResult<User> usersPage=usersResult.get();
    assertAll(() -> assertEquals(totalUsersCount,usersPage.getTotalResults()),() -> assertEquals(startIndex,usersPage.getStartIndex()),() -> assertEquals(returnedUsersCount,usersPage.getItemsPerPage()),() -> assertEquals(returnedUsersCount,usersPage.getResources().size()));
  }
);
}
