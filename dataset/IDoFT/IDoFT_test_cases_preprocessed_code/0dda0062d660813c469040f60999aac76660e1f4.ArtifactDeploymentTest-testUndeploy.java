private void testUndeploy(final UndeployArtifactMojo mojo,final String classifier) throws Exception {
if (!deploymentManager.hasDeployment(artifactName)) {
}
assertFalse("Deployment " + artifactName + " was not undeployed",deploymentManager.hasDeployment(artifactName));
}