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

#import "EC2Tag.h"



/**
 * Reserved Instances
 *
 * \ingroup EC2
 */

@interface EC2ReservedInstances:NSObject

{
    NSString       *reservedInstancesId;
    NSString       *instanceType;
    NSString       *availabilityZone;
    NSDate         *start;
    NSNumber       *duration;
    NSNumber       *usagePrice;
    NSNumber       *fixedPrice;
    NSNumber       *instanceCount;
    NSString       *productDescription;
    NSString       *state;
    NSMutableArray *tags;
}



/**
 * Default constructor for a new  object.  Callers should use the
 * property methods to initialize this object after creating it.
 */
-(id)init;

/**
 * The unique ID of the Reserved Instances purchase.
 */
@property (nonatomic, retain) NSString *reservedInstancesId;

/**
 * The instance type on which the Reserved Instances can be used.
 * <p>
 * <b>Constraints:</b><br/>
 * <b>Allowed Values: </b>t1.micro, m1.small, m1.large, m1.xlarge, m2.xlarge, m2.2xlarge, m2.4xlarge, c1.medium, c1.xlarge, cc1.4xlarge, cg1.4xlarge
 */
@property (nonatomic, retain) NSString *instanceType;

/**
 * The Availability Zone in which the Reserved Instances can be used.
 */
@property (nonatomic, retain) NSString *availabilityZone;

/**
 * The date and time the Reserved Instances started.
 */
@property (nonatomic, retain) NSDate *start;

/**
 * The duration of the Reserved Instances, in seconds.
 */
@property (nonatomic, retain) NSNumber *duration;

/**
 * The usage price of the Reserved Instances, per hour.
 */
@property (nonatomic, retain) NSNumber *usagePrice;

/**
 * The purchase price of the Reserved Instances.
 */
@property (nonatomic, retain) NSNumber *fixedPrice;

/**
 * The number of Reserved Instances purchased.
 */
@property (nonatomic, retain) NSNumber *instanceCount;

/**
 * The Reserved Instances product description (ex: Windows or
 * Unix/Linux).
 */
@property (nonatomic, retain) NSString *productDescription;

/**
 * The state of the Reserved Instances purchase.
 */
@property (nonatomic, retain) NSString *state;

/**
 * A list of tags for the ReservedInstances.
 */
@property (nonatomic, retain) NSMutableArray *tags;

/**
 * Adds a single object to tags.
 * This function will alloc and init tags if not already done.
 */
-(void)addTag:(EC2Tag *)tag;

/**
 * Returns a string representation of this object; useful for testing and
 * debugging.
 *
 * @return A string representation of this object.
 */
-(NSString *)description;


@end
