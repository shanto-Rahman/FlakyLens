@Test public void addRemoveSet() throws Exception {
if (i < 20) {
}
if (exists(node)) {
if (result != null) {
}
}
if (exists(node)) {
if (result != null) {
}
}
if (exists(node)) {
if (result != null) {
}
}
if (exists(node) && !exists(node2)) {
if (result != null) {
}
}
if (isConflict(node)) {
if (exists(node) && !exists(node2)) {
if (result != null) {
}
}
}
fail();
if (result == null) {
if (j != mkId) {
}
}
if (Integer.bitCount(maskOk) != opCount) {
fail("Not all operations were at least once successful: " + Integer.toBinaryString(maskOk));
}
if (Integer.bitCount(maskFail) != opCount) {
fail("Not all operations failed at least once: " + Integer.toBinaryString(maskFail));
}
}