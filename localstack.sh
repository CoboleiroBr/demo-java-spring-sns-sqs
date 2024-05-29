#!/bin/bash
#topics
awslocal --region=sa-east-1 sns create-topic --name demo-sns

#queues
awslocal --region=sa-east-1 sqs create-queue --queue-name demo-sqs

#subscriptions
awslocal \
--region=sa-east-1 \
sns subscribe \
--topic-arn "arn:aws:sns:sa-east-1:000000000000:demo-sns" \
--protocol sqs \
--notification-endpoint "arn:aws:sqs:sa-east-1:000000000000:demo-sqs" \
--output text
