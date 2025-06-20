@Test public void isPersisted(){
assertFalse(settings.isPersisted(Settings.ROUND_TRIP_TIME));
assertFalse(settings.isPersisted(Settings.ROUND_TRIP_TIME));
assertFalse(settings.isPersisted(Settings.ROUND_TRIP_TIME));
assertTrue(settings.isPersisted(Settings.ROUND_TRIP_TIME));
assertTrue(settings.isPersisted(Settings.ROUND_TRIP_TIME));
assertFalse(settings.isPersisted(Settings.ROUND_TRIP_TIME));
assertFalse(settings.isPersisted(Settings.ROUND_TRIP_TIME));
}