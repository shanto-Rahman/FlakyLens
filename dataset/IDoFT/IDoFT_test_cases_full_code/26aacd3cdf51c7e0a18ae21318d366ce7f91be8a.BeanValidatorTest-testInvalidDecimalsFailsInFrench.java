@Test public void testInvalidDecimalsFailsInFrench(){
  setLocale(Locale.FRENCH);
  BeanValidator v=validator("decimals");
  assertFails("1234.567","valeur numérique hors limite " + "(<3 chiffres>.<2 chiffres> attendu)",v);
}
