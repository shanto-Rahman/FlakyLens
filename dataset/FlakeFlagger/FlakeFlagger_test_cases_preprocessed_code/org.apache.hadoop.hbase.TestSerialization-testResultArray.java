public void testResultArray() throws Exception {
assertTrue(results.length == deResults.length);
assertTrue(keysA.length == keysB.length);
assertTrue("Expected equivalent keys but found:\n" + "KeyA : " + keysA[j].toString() + "\n"+ "KeyB : "+ keysB[j].toString()+ "\n"+ keysA.length+ " total keys, "+ i+ "th so far",keysA[j].equals(keysB[j]));
}