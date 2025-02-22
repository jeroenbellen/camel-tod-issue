/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.dropbox;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.v2.DbxClientV2;
import org.apache.camel.component.dropbox.util.DropboxOperation;
import org.apache.camel.component.dropbox.util.DropboxUploadMode;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;

@UriParams
public class DropboxConfiguration {

    //specific dropbox operation for the component
    @UriPath
    @Metadata(required = true)
    private DropboxOperation operation;

    //dropbox auth options
    @UriParam
    @Metadata(label = "security", required = true, secret = true)
    private String accessToken;
    @UriParam
    @Metadata(label = "security", required = true, secret = true)
    private Long expireIn;
    @UriParam
    @Metadata(label = "security", required = true, secret = true)
    private String refreshToken;
    @UriParam
    @Metadata(label = "security", required = true, secret = true)
    private String apiKey;
    @UriParam
    @Metadata(label = "security", required = true, secret = true)
    private String apiSecret;

    //local path to put files
    @UriParam(label = "producer")
    private String localPath;
    //where to put files on dropbox
    @UriParam(label = "common")
    private String remotePath;
    //new path on dropbox when moving files
    @UriParam(label = "producer")
    private String newRemotePath;
    //search query on dropbox
    @UriParam(label = "common")
    private String query;
    //in case of uploading if force or add existing file
    @UriParam(label = "producer")
    private DropboxUploadMode uploadMode;
    //id of the app
    @UriParam(label = "common")
    private String clientIdentifier;
    //reference to dropbox client
    @UriParam(label = "advanced")
    private DbxClientV2 client;

    /**
     * To use an existing DbxClient instance as DropBox client.
     */
    public void setClient(DbxClientV2 client) {
        this.client = client;
    }

    public DbxClientV2 getClient() {
        return client;
    }

    /**
     * Obtain a new instance of DbxClient and store it in configuration.
     */
    public void createClient() {
        DbxRequestConfig config = DbxRequestConfig.newBuilder(clientIdentifier).build();
        DbxCredential credential = new DbxCredential(accessToken, expireIn, refreshToken, apiKey, apiSecret);
        this.client = new DbxClientV2(config, credential);
    }

    public String getAccessToken() {
        return accessToken;
    }

    /**
     * The access token to make API requests for a specific Dropbox user
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLocalPath() {
        return localPath;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * The refresh token to refresh the access token for a specific Dropbox user
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getApiKey() {
        return apiKey;
    }

    /**
     * The apiKey to make API requests for a specific Dropbox user
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * The apiSecret to make API requests for a specific Dropbox user
     */
    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    /**
     * The expire time to access token for a specific Dropbox user
     */
    public Long getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Long expireIn) {
        this.expireIn = expireIn;
    }

    /**
     * Optional folder or file to upload on Dropbox from the local filesystem. If this option has not been configured
     * then the message body is used as the content to upload.
     */
    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getRemotePath() {
        return remotePath;
    }

    /**
     * Original file or folder to move
     */
    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getNewRemotePath() {
        return newRemotePath;
    }

    /**
     * Destination file or folder
     */
    public void setNewRemotePath(String newRemotePath) {
        this.newRemotePath = newRemotePath;
    }

    public String getQuery() {
        return query;
    }

    /**
     * A space-separated list of sub-strings to search for. A file matches only if it contains all the sub-strings. If
     * this option is not set, all files will be matched.
     */
    public void setQuery(String query) {
        this.query = query;
    }

    public String getClientIdentifier() {
        return clientIdentifier;
    }

    /**
     * Name of the app registered to make API requests
     */
    public void setClientIdentifier(String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    public DropboxOperation getOperation() {
        return operation;
    }

    /**
     * The specific action (typically is a CRUD action) to perform on Dropbox remote folder.
     */
    public void setOperation(DropboxOperation operation) {
        this.operation = operation;
    }

    public DropboxUploadMode getUploadMode() {
        return uploadMode;
    }

    /**
     * Which mode to upload. in case of "add" the new file will be renamed if a file with the same name already exists
     * on dropbox. in case of "force" if a file with the same name already exists on dropbox, this will be overwritten.
     */
    public void setUploadMode(DropboxUploadMode uploadMode) {
        this.uploadMode = uploadMode;
    }

}
