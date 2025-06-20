@Test public void testReasonPhrases() throws IllegalAccessException {
Assert.assertNotNull(publicFields);
Assert.assertTrue(publicFields.length > 0);
if ((f.getType() == int.class) && Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers)&& Modifier.isStatic(modifiers)) {
Assert.assertNotNull("text is null for HttpStatus." + f.getName(),text);
Assert.assertTrue(text.length() > 0);
}
}