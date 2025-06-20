@Test public void testReadUsersWithPagedByIdentityResponse() throws IOException {
assertAll(() -> assertNotNull(user.getUserName()),() -> assertNotNull(user.getDisplayName()),() -> assertNotNull(user.isActive()));
}