@SuppressWarnings("unchecked") @Test public void testPresentationHeader() throws Exception {
assertEquals("Level",elementList.get(0).getText());
assertEquals("Thread",elementList.get(1).getText());
assertEquals("Message",elementList.get(2).getText());
}