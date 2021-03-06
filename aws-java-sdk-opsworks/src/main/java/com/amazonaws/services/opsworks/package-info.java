
/**
 * Synchronous and asynchronous client classes for accessing AWSOpsWorks.
 *
 * AWS OpsWorks <p>
 * Welcome to the <i>AWS OpsWorks API Reference</i> . This guide provides
 * descriptions, syntax, and usage examples about AWS OpsWorks actions
 * and data types, including common parameters and error codes.
 * </p>
 * <p>
 * AWS OpsWorks is an application management service that provides an
 * integrated experience for overseeing the complete application
 * lifecycle. For information about this product, go to the
 * <a href="http://aws.amazon.com/opsworks/"> AWS OpsWorks </a>
 * details page.
 * </p>
 * <p>
 * <b>SDKs and CLI</b>
 * </p>
 * <p>
 * The most common way to use the AWS OpsWorks API is by using the AWS
 * Command Line Interface (CLI) or by using one of the AWS SDKs to
 * implement applications in your preferred language. For more
 * information, see:
 * </p>
 * 
 * <ul>
 * <li>
 * <a href="http://docs.aws.amazon.com/cli/latest/userguide/cli-chap-welcome.html"> AWS CLI </a>
 * </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/opsworks/AWSOpsWorksClient.html"> AWS SDK for Java </a>
 * </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/sdkfornet/latest/apidocs/html/N_Amazon_OpsWorks.htm"> AWS SDK for .NET </a>
 * </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/aws-sdk-php-2/latest/class-Aws.OpsWorks.OpsWorksClient.html"> AWS SDK for PHP 2 </a>
 * </li>
 * <li>
 * <a href="http://docs.aws.amazon.com/AWSRubySDK/latest/AWS/OpsWorks/Client.html"> AWS SDK for Ruby </a>
 * </li>
 * <li>
 * <a href="http://aws.amazon.com/documentation/sdkforjavascript/"> AWS SDK for Node.js </a>
 * </li>
 * <li>
 * <a href="http://docs.pythonboto.org/en/latest/ref/opsworks.html"> AWS SDK for Python(Boto) </a>
 * </li>
 * 
 * </ul>
 * <p>
 * <b>Endpoints</b>
 * </p>
 * <p>
 * AWS OpsWorks supports only one endpoint,
 * opsworks.us-east-1.amazonaws.com (HTTPS), so you must connect to that
 * endpoint. You can then use the API to direct AWS OpsWorks to create
 * stacks in any AWS Region.
 * </p>
 * <p>
 * <b>Chef Versions</b>
 * </p>
 * <p>
 * When you call CreateStack, CloneStack, or UpdateStack we recommend you
 * use the <code>ConfigurationManager</code> parameter to specify the
 * Chef version. The recommended value for Linux stacks, which is also
 * the default value, is currently 11.10. Windows stacks use Chef 12.2.
 * For more information, see
 * <a href="http://docs.aws.amazon.com/opsworks/latest/userguide/workingcookbook-chef11.html"> Chef Versions </a>
 * .
 * </p>
 * <p>
 * <b>NOTE:</b>You can also specify Chef 11.4 or Chef 0.9 for your Linux
 * stack. However, Chef 0.9 has been deprecated. We do not recommend
 * using Chef 0.9 for new stacks, and we recommend migrating your
 * existing Chef 0.9 stacks to Chef 11.10 as soon as possible.
 * </p>
 */
 package com.amazonaws.services.opsworks;
        