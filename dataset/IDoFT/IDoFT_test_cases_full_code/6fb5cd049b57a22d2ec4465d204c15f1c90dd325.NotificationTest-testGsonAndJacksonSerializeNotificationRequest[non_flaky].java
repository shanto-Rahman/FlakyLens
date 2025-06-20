@Test public void testGsonAndJacksonSerializeNotificationRequest() throws JsonProcessingException {
  NotificationRequest notificationRequest=new NotificationRequest();
  notificationRequest.setLive("live");
  NotificationRequestItemContainer notificationContainer=new NotificationRequestItemContainer();
  NotificationRequestItem notificationRequestItem=new NotificationRequestItem();
  notificationRequestItem.setAmount(new Amount());
  notificationRequestItem.setEventCode("eventcode");
  notificationContainer.setNotificationItem(notificationRequestItem);
  notificationRequest.setNotificationItemContainers(Collections.singletonList(notificationContainer));
  String gson=GSON.toJson(notificationRequest);
  String jackson=OBJECT_MAPPER.writeValueAsString(notificationRequest);
  assertJsonStringEquals(jackson,gson);
}
