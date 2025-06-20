@Test public void persistValue(){
assertFalse(settings.persistValue(Settings.ROUND_TRIP_TIME));
assertFalse(settings.persistValue(Settings.ROUND_TRIP_TIME));
assertFalse(settings.persistValue(Settings.ROUND_TRIP_TIME));
assertTrue(settings.persistValue(Settings.ROUND_TRIP_TIME));
assertTrue(settings.persistValue(Settings.ROUND_TRIP_TIME));
assertFalse(settings.persistValue(Settings.ROUND_TRIP_TIME));
assertFalse(settings.persistValue(Settings.ROUND_TRIP_TIME));
}