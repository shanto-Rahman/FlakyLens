@Test public void shouldHideChatFromUnauthed(){
  given(settings.getProperty(RestrictionSettings.ALLOW_CHAT)).willReturn(false);
  AsyncPlayerChatEvent event=newAsyncChatEvent();
  given(listenerService.shouldCancelEvent(event.getPlayer())).willReturn(false);
  given(settings.getProperty(RestrictionSettings.HIDE_CHAT)).willReturn(true);
  List<Player> recipients=new ArrayList<>(event.getRecipients());
  given(listenerService.shouldCancelEvent(recipients.get(0))).willReturn(true);
  listener.onPlayerChat(event);
  verify(listenerService).shouldCancelEvent(event.getPlayer());
  verify(listenerService,times(4)).shouldCancelEvent(any(Player.class));
  verify(event,never()).setCancelled(anyBoolean());
  assertThat(event.getRecipients(),containsInAnyOrder(recipients.get(1),recipients.get(2)));
}
