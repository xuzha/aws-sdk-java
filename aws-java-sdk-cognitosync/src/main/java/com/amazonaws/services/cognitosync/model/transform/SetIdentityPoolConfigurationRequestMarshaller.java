/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.cognitosync.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import static com.amazonaws.util.StringUtils.COMMA_SEPARATOR;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitosync.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Set Identity Pool Configuration Request Marshaller
 */
public class SetIdentityPoolConfigurationRequestMarshaller implements Marshaller<Request<SetIdentityPoolConfigurationRequest>, SetIdentityPoolConfigurationRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "/identitypools/{IdentityPoolId}/configuration";
        Map<String, String> staticMap = new HashMap<String, String>();
        Map<String, String> dynamicMap = new HashMap<String, String>();

        int index = path.indexOf("?");
        if (index != -1) {
            String queryString = path.substring(index + 1);
            path = path.substring(0, index);

            for (String s : queryString.split("[;&]")) {
                index = s.indexOf("=");
                if (index != -1) {
                    String name = s.substring(0, index);
                    String value = s.substring(index + 1);

                    if (value.startsWith("{") && value.endsWith("}")) {
                        dynamicMap.put(value.substring(1, value.length() - 1), name);
                    } else {
                        staticMap.put(name, value);
                    }
                }
            }
        }

        RESOURCE_PATH_TEMPLATE = path;
        STATIC_QUERY_PARAMS = Collections.unmodifiableMap(staticMap);
        DYNAMIC_QUERY_PARAMS = Collections.unmodifiableMap(dynamicMap);
    }

    public Request<SetIdentityPoolConfigurationRequest> marshall(SetIdentityPoolConfigurationRequest setIdentityPoolConfigurationRequest) {
        if (setIdentityPoolConfigurationRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<SetIdentityPoolConfigurationRequest> request = new DefaultRequest<SetIdentityPoolConfigurationRequest>(setIdentityPoolConfigurationRequest, "AmazonCognitoSync");
        String target = "AWSCognitoSyncService.SetIdentityPoolConfiguration";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        String uriResourcePath = RESOURCE_PATH_TEMPLATE;

        if (DYNAMIC_QUERY_PARAMS.containsKey("IdentityPoolId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("IdentityPoolId");

            String value = (setIdentityPoolConfigurationRequest.getIdentityPoolId() == null) ? null : StringUtils.fromString(setIdentityPoolConfigurationRequest.getIdentityPoolId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
            
        } else {
            uriResourcePath = uriResourcePath.replace("{IdentityPoolId}", (setIdentityPoolConfigurationRequest.getIdentityPoolId() == null) ? "" : StringUtils.fromString(setIdentityPoolConfigurationRequest.getIdentityPoolId())); 
        } 

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            PushSync pushSync = setIdentityPoolConfigurationRequest.getPushSync();
            if (pushSync != null) {

                jsonWriter.key("PushSync");
                jsonWriter.object();

                com.amazonaws.internal.ListWithAutoConstructFlag<String> applicationArnsList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(pushSync.getApplicationArns());
                if (applicationArnsList != null && !(applicationArnsList.isAutoConstruct() && applicationArnsList.isEmpty())) {

                    jsonWriter.key("ApplicationArns");
                    jsonWriter.array();

                    for (String applicationArnsListValue : applicationArnsList) {
                        if (applicationArnsListValue != null) {
                            jsonWriter.value(applicationArnsListValue);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (pushSync.getRoleArn() != null) {
                    jsonWriter.key("RoleArn").value(pushSync.getRoleArn());
                }
                jsonWriter.endObject();
            }
            CognitoStreams cognitoStreams = setIdentityPoolConfigurationRequest.getCognitoStreams();
            if (cognitoStreams != null) {

                jsonWriter.key("CognitoStreams");
                jsonWriter.object();

                if (cognitoStreams.getStreamName() != null) {
                    jsonWriter.key("StreamName").value(cognitoStreams.getStreamName());
                }
                if (cognitoStreams.getRoleArn() != null) {
                    jsonWriter.key("RoleArn").value(cognitoStreams.getRoleArn());
                }
                if (cognitoStreams.getStreamingStatus() != null) {
                    jsonWriter.key("StreamingStatus").value(cognitoStreams.getStreamingStatus());
                }
                jsonWriter.endObject();
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.0");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
