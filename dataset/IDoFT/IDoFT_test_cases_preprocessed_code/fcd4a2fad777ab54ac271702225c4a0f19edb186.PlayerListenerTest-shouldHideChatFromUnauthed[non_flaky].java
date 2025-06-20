@Test public void shouldHideChatFromUnauthed(){
assertThat(event.getRecipients(),containsInAnyOrder(recipients.get(1),recipients.get(2)));
}