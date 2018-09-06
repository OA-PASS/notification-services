/*
 * Copyright 2018 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dataconservancy.pass.notification.model;

import java.net.URI;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * Encapsulates {@link Notification} metadata used to dispatch the notification.
 *
 * @author Elliot Metsger (emetsger@jhu.edu)
 */
public class SimpleNotification implements Notification {

    /**
     * The primary recipients of the notification, may URIs to a PASS {@code User} or 'mailto' URIs
     */
    private Collection<String> recipients;

    /**
     * The sender of the notification.
     */
    private String sender;

    /**
     * Additional recipients, may be URIs to PASS {@code User}s
     */
    private Collection<String> cc;

    /**
     * The type of {@link Notification}
     */
    private Notification.Type type;

    /**
     * Parameter map used for resolving placeholders in notification templates
     *
     * @see Notification.Param
     */
    private Map<Param, String> parameters;

    /**
     * The link to the {@code SubmissionEvent} this notification is in response to
     */
    private URI eventUri;

    /**
     * The link to the PASS resource this notification is in response to; likely to be the same as the
     * {@code SubmissionEvent#submissionUri}
     */
    private URI resourceUri;

    public Collection<String> getRecipients() {
        return recipients;
    }

    public void setRecipient(Collection<String> recipients) {
        this.recipients = recipients;
    }

    public Collection<String> getCc() {
        return cc;
    }

    public void setCc(Collection<String> cc) {
        this.cc = cc;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Map<Param, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<Param, String> parameters) {
        this.parameters = parameters;
    }

    public URI getEventUri() {
        return eventUri;
    }

    public void setEventUri(URI eventUri) {
        this.eventUri = eventUri;
    }

    public URI getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(URI resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SimpleNotification that = (SimpleNotification) o;
        return Objects.equals(recipients, that.recipients) &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(cc, that.cc) &&
                type == that.type &&
                Objects.equals(parameters, that.parameters) &&
                Objects.equals(eventUri, that.eventUri) &&
                Objects.equals(resourceUri, that.resourceUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipients, sender, cc, type, parameters, eventUri, resourceUri);
    }

    @Override
    public String toString() {
        return "SimpleNotification{" +
                "recipients=" + recipients +
                ", sender='" + sender + '\'' +
                ", cc=" + cc +
                ", type=" + type +
                ", parameters=" + parameters +
                ", eventUri=" + eventUri +
                ", resourceUri=" + resourceUri +
                '}';
    }

}
