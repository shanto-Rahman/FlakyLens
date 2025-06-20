@Test public void testAllocateConference() throws Exception {
FocusComponent focusComponent=osgi.jicofoServices.getFocusComponent();//RW
assertNotNull(result);
assertTrue(response instanceof ConferenceIq);
}