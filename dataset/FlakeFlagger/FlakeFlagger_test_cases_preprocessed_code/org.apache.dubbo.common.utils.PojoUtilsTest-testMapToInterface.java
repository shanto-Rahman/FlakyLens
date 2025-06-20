@Test public void testMapToInterface() throws Exception {
assertThat(message.getContent(),equalTo("greeting"));//IT
assertThat(message.getFrom(),equalTo("dubbo"));//IT
assertTrue(message.isUrgent());//IT
}