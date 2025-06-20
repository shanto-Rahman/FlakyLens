@Test @InSequence(7) public void checkConversationScope() throws IOException {
String output=getResponse(new URL(indexUrl.toString() + "/" + VegetablePage.class.getSimpleName()));//RW
}