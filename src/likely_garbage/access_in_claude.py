# @zijwan
import boto3
import time
import datetime

region_name='us-west-2'
class BedrockClientWithAutoRefresh:
    def __init__(self, role_arn, session_name):
        self.role_arn = role_arn
        self.session_name = session_name
        self.session = boto3.Session()
        self.sts_client = self.session.client('sts', region_name=region_name)
        self.bedrock_client = None
        self.expiration = None
        self.refresh_credentials()

    def refresh_credentials(self):
        print('authorizing')
        assumed_role = self.sts_client.assume_role(
            RoleArn=self.role_arn,
            RoleSessionName=self.session_name,
            DurationSeconds=12*60*60
        )
        credentials = assumed_role['Credentials']
        self.bedrock_client = boto3.client(
            'bedrock-runtime',
            aws_access_key_id=credentials['AccessKeyId'],
            aws_secret_access_key=credentials['SecretAccessKey'],
            aws_session_token=credentials['SessionToken'],
            region_name=region_name
        )
        self.expiration = credentials['Expiration']
        print(f'current expiration: {self.expiration}')

    def make_bedrock_call(self, api_call_function, *args, **kwargs):
        if self.expiration is None or datetime.datetime.now(datetime.timezone.utc) > self.expiration - datetime.timedelta(minutes=10):
            self.refresh_credentials()
        return api_call_function(self.bedrock_client, *args, **kwargs)

