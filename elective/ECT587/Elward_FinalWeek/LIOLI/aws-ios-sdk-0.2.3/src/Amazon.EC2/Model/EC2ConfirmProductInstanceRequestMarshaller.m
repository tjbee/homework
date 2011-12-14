/*
 * Copyright 2010-2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

#import "EC2ConfirmProductInstanceRequestMarshaller.h"

@implementation EC2ConfirmProductInstanceRequestMarshaller

+(AmazonServiceRequest *)createRequest:(EC2ConfirmProductInstanceRequest *)confirmProductInstanceRequest
{
    AmazonServiceRequest *request = [[EC2Request alloc] init];

    [request setParameterValue:@"ConfirmProductInstance"           forKey:@"Action"];
    [request setParameterValue:@"2011-01-01"   forKey:@"Version"];

    [request setDelegate:[confirmProductInstanceRequest delegate]];
    [request setCredentials:[confirmProductInstanceRequest credentials]];
    [request setEndpoint:[confirmProductInstanceRequest requestEndpoint]];

    if (confirmProductInstanceRequest != nil) {
        if (confirmProductInstanceRequest.productCode != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", confirmProductInstanceRequest.productCode] forKey:[NSString stringWithFormat:@"%@", @"ProductCode"]];
        }
    }
    if (confirmProductInstanceRequest != nil) {
        if (confirmProductInstanceRequest.instanceId != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", confirmProductInstanceRequest.instanceId] forKey:[NSString stringWithFormat:@"%@", @"InstanceId"]];
        }
    }


    return [request autorelease];
}

@end

