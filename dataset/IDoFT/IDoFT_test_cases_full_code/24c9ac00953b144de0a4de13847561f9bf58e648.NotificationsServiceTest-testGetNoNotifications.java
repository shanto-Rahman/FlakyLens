@Test public void testGetNoNotifications() throws Throwable {
  NotificationsAggregatorState notifications;
  notifications=getNotifications(NotificationsService.SELF_LINK,null);
  Assert.assertNotNull(notifications);
  Assert.assertEquals(0,notifications.recentEventLogsCount);
  Assert.assertEquals(0,notifications.activeRequestsCount);
  notifications=getNotifications(NotificationsService.SELF_LINK,PROJECT_LINK);
  Assert.assertNotNull(notifications);
  Assert.assertEquals(0,notifications.recentEventLogsCount);
  Assert.assertEquals(0,notifications.activeRequestsCount);
  String notificationsUri=String.format("%s?%s",NotificationsService.SELF_LINK,UriUtils.buildUriQuery(MultiTenantDocument.FIELD_NAME_TENANT_LINKS,TENANT_LINK));
  notifications=getNotifications(notificationsUri,PROJECT_LINK);
  Assert.assertNotNull(notifications);
  Assert.assertEquals(0,notifications.recentEventLogsCount);
  Assert.assertEquals(0,notifications.activeRequestsCount);
}
