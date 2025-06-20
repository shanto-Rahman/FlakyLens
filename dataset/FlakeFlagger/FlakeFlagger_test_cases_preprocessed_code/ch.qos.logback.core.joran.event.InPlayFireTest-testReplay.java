@Test public void testReplay() throws JoranException {
assertEquals(5,listenAction.getSeList().size());
assertTrue(listenAction.getSeList().get(0) instanceof StartEvent);
assertTrue(listenAction.getSeList().get(1) instanceof StartEvent);
assertTrue(listenAction.getSeList().get(2) instanceof BodyEvent);
assertTrue(listenAction.getSeList().get(3) instanceof EndEvent);
}