<%@ include file="../../../../includes.jspf"%>
<%--
  ~ Copyright 2016 Karl Dahlgren
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~   http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
  --%>

<c:url var="create_websocket_topic_url"  value="/web/wss/project/${webSocketProjectId}/create/topic" />
<div class="content-top">
    <h1><spring:message code="websocket.createtopic.header.topic"/></h1>
</div>
<form:form action="${create_websocket_topic_url}" method="POST" commandName="webSocketTopic">
    <table class="formTable">
        <tr>
            <td class="column1"><label><spring:message code="websocket.createtopic.label.name"/></label></td>
            <td class="column2"><form:input id="webSocketTopicNameInput" path="name" /></td>
        </tr>
    </table>
 
    <button class="button-success pure-button" type="submit" name="submit"><i class="fa fa-plus"></i> <span><spring:message code="websocket.createtopic.button.createtopic"/></span></button>
    <a href="<c:url value="/web/wss/project/${webSocketProjectId}"/>" class="button-error pure-button"><i class="fa fa-times"></i> <span><spring:message code="websocket.createtopic.button.cancel"/></span></a>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
<script>
    $("#webSocketTopicNameInput").attr('required', '');
</script>