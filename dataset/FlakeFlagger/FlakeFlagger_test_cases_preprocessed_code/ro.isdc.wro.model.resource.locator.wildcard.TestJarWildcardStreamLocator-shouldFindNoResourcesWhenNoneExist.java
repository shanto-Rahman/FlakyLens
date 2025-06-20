@Test public void shouldFindNoResourcesWhenNoneExist() throws IOException {
final Collection<String> filenameList=filenameListHolder.get();
Assert.assertNotNull(filenameList);
Assert.assertTrue(filenameList.isEmpty());
}