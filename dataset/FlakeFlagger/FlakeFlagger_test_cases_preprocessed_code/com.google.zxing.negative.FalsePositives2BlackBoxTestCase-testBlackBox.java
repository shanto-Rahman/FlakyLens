@Override @Test public void testBlackBox() throws IOException {
assertFalse(testResults.isEmpty());
if (image == null) {
}
if (!checkForFalsePositives(image,testResult.getRotation())) {
}
if (totalFalsePositives < totalAllowed) {
if (totalFalsePositives > totalAllowed) {
}
}
assertTrue("Rotation " + testResult.getRotation() + " degrees: Too many false positives found",falsePositives[x] <= testResult.getFalsePositivesAllowed());
}