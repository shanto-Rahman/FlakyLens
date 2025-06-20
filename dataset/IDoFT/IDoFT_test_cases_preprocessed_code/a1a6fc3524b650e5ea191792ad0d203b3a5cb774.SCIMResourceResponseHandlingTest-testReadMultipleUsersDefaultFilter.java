@Test public void testReadMultipleUsersDefaultFilter() throws JsonProcessingException {
assertTrue(usersResult.isSuccess());
assertAll(() -> assertEquals(totalUsersCount,usersPage.getTotalResults()),() -> assertEquals(1,usersPage.getStartIndex()),() -> assertEquals(returnedUsersCount,usersPage.getItemsPerPage()),() -> assertEquals(returnedUsersCount,usersPage.getResources().size()));
}